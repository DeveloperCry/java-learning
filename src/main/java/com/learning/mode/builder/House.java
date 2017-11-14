/**
 * 
 */
package com.learning.mode.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;


/**
 * @author Xiong.Liu
 *
 */
public class House {
	private List<String> components = new ArrayList<String>();
	
	public void addComponents(String component) {
		components.add(component);
	}
	
	public void show() {
		System.out.println("==========show===========");
		if (CollectionUtils.isNotEmpty(components)) {
			components.forEach(component -> {
				System.out.println(component);
			});
		}
	}
}
