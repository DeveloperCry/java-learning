/**
 * 
 */
package com.learning.mode.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milier
 *
 */
public class DeepThing implements Cloneable {
	private ArrayList<String> list = new ArrayList<String>();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected DeepThing clone() {
		DeepThing thing = null;
		
		try {
			thing = (DeepThing)super.clone();
			thing.list = (ArrayList<String>)this.list.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return thing;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return this.list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(String value) {
		this.list.add(value);
	}
}
