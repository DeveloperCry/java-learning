/**
 * 
 */
package com.spring.framework.example.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Xiong.Liu
 *
 */
public class StringToInteger implements Converter<String, Integer>{

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Integer convert(String source) {
		// TODO Auto-generated method stub
		return Integer.valueOf(source);
	}

}
