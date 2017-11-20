/**
 * 
 */
package com.learning.mode.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milier
 * Ç³¿½±´»úÖÆ
 */
public class Thing implements Cloneable{
	
	private List<String> list = new ArrayList<String>();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Thing clone() {
		Thing thing = null;
		
		try {
			thing = (Thing)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return thing;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(String value) {
		this.list.add(value);
	}
	
}
