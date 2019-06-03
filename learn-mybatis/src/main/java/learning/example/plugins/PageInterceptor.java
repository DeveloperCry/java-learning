/**
 * 
 */
package learning.example.plugins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import learning.example.enity.Page;
import learning.example.utils.ReflectUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

/**
 * 
 * For prepare, the args must include Integer.class
 * 
 * @author Xiong.Liu
 *
 */
@Intercepts({@Signature(
	method = "prepare",
	type = StatementHandler.class,
	args = {Connection.class, Integer.class}
			
)})
public class PageInterceptor implements Interceptor{
	
	private String databaseType;

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		StatementHandler delegate = (StatementHandler) ReflectUtils.getFieldValue(handler, "delegate");
		
		BoundSql boundSql = delegate.getBoundSql();
		Object object = boundSql.getParameterObject();
		if (object instanceof Page<?>) {
			Page<?> page = (Page<?>) object;
			MappedStatement mappedStatement = (MappedStatement) ReflectUtils.getFieldValue(delegate, "mappedStatement");
			Connection connection = (Connection) invocation.getArgs()[0];
			
			String sql = boundSql.getSql();
			
			this.setTotalRecord(page, mappedStatement, connection);
			String pageSql = this.getPageSql(page, sql);
			ReflectUtils.setFieldValue(boundSql, "sql", pageSql);
		}
		return invocation.proceed();
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType");
	}
	
	private String getPageSql(Page<?> page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		
		if ("mysql".equalsIgnoreCase(databaseType)) {
			return this.getMySqlPageSql(page, sqlBuffer);
		} else if ("oracle".equalsIgnoreCase(databaseType)) {
			return this.getOraclePageSql(page, sqlBuffer);
		}
		return sqlBuffer.toString();
	}
	
	private String getMySqlPageSql(Page<?> page, StringBuffer sqlBuffer) {
		int offset = (page.getPageNo() - 1) * page.getPageSize();
		sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());
		return sqlBuffer.toString();
	}
	
	
	private String getOraclePageSql(Page<?> page, StringBuffer sqlBuffer) {
		int offset = (page.getPageNo() - 1) * page.getPageSize() + 1;
		sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getPageSize());
		sqlBuffer.insert(0, "select * from (").append(") where r >=").append(offset);
		
		return sqlBuffer.toString();
	}
	
	private void setTotalRecord(Page<?> page, MappedStatement mappedStatement, Connection connection) {
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		String sql = boundSql.getSql();
		String countRecordSql = this.getCountRecordSql(sql);
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		BoundSql countRecordBoundSql = new BoundSql(mappedStatement.getConfiguration(), countRecordSql, parameterMappings, page);
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countRecordBoundSql);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countRecordSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				
				page.setTotalRecord(totalRecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getCountRecordSql(String sql) {
		int index = sql.toUpperCase().indexOf("FROM");
		return "select count(*) " + sql.substring(index);
	}

}
