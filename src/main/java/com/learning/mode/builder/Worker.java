/**
 * 
 */
package com.learning.mode.builder;

/**
 * @author Xiong.Liu
 *
 */
public class Worker implements Builder{
	private House house = new House();

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#buildFoundation()
	 */
	@Override
	public void buildFoundation() {
		house.addComponents("Foundation");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#buildWall()
	 */
	@Override
	public void buildWall() {
		house.addComponents("buildWall");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#buildRoof()
	 */
	@Override
	public void buildRoof() {
		house.addComponents("Roof");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#buildWindow()
	 */
	@Override
	public void buildWindow() {
		house.addComponents("Window");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#buildDoor()
	 */
	@Override
	public void buildDoor() {
		house.addComponents("Door");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.builder.Builder#createHouse()
	 */
	@Override
	public House createHouse() {
		return house;
	}

}
