/**
 * 
 */
package learning.example.enity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiong.Liu
 *
 */
public class Page<T> {
	private int pageNo = 1;
	private int pageSize = 2;
	private int totalRecord;
	private int totalPage;
	private List<T> results;
	private Map<String, Object> params = new HashMap<String, Object>();//other parameters
	
	/**
	 * Gets pageNo
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	
	/**
	 * Sets pageNo the pageNo
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Gets pageSize
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * Sets pageSize the pageSize
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * Gets totalRecord
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	
	/**
	 * Sets totalRecord the totalRecord
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		int totalPages = totalRecord % this.pageSize == 0 ? totalRecord / this.pageSize : (totalRecord / this.pageSize) + 1;
		this.setTotalPage(totalPages);
	}
	
	/**
	 * Gets totalPage
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * Sets totalPage the totalPage
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * Gets results
	 * @return the results
	 */
	public List<T> getResults() {
		return results;
	}
	
	/**
	 * Sets results the results
	 * @param results the results to set
	 */
	public void setResults(List<T> results) {
		this.results = results;
	}
	
	/**
	 * Gets params
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return params;
	}
	
	/**
	 * Sets params the params
	 * @param params the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", totalPage="
				+ totalPage + "]";
	}
	
	
}
