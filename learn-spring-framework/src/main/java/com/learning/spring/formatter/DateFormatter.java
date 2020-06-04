/**
 * 
 */
package com.learning.spring.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;

/**
 * @author Xiong.Liu
 *
 */
public class DateFormatter implements Formatter<Date>{
	private String pattern;
	
	/**
	 * 
	 */
	public DateFormatter(String pattern) {
		this.pattern = pattern;
	}
	/* (non-Javadoc)
	 * @see org.springframework.format.Printer#print(java.lang.Object, java.util.Locale)
	 */
	@Override
	public String print(Date date, Locale locale) {
		if (date == null) {
			return "";
		}
		return this.getDateFormat(locale).format(date);
	}

	/* (non-Javadoc)
	 * @see org.springframework.format.Parser#parse(java.lang.String, java.util.Locale)
	 */
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if (StringUtils.isEmpty(text)) {
			return null;
		}
		return this.getDateFormat(locale).parse(text);
	}
	
	protected DateFormat getDateFormat(Locale locale) {
		DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
		dateFormat.setLenient(false);
		return dateFormat;
	}

}
