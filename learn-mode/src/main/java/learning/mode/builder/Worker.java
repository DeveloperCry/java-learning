/**
 * 
 */
package learning.mode.builder;

/**
 * @author Xiong.Liu
 *
 */
public class Worker implements Builder{
	private House house = new House();

	/* (non-Javadoc)
	 * @see Builder#buildFoundation()
	 */
	@Override
	public void buildFoundation() {
		house.addComponents("Foundation");
	}

	/* (non-Javadoc)
	 * @see Builder#buildWall()
	 */
	@Override
	public void buildWall() {
		house.addComponents("buildWall");
	}

	/* (non-Javadoc)
	 * @see Builder#buildRoof()
	 */
	@Override
	public void buildRoof() {
		house.addComponents("Roof");
	}

	/* (non-Javadoc)
	 * @see Builder#buildWindow()
	 */
	@Override
	public void buildWindow() {
		house.addComponents("Window");
	}

	/* (non-Javadoc)
	 * @see Builder#buildDoor()
	 */
	@Override
	public void buildDoor() {
		house.addComponents("Door");
	}

	/* (non-Javadoc)
	 * @see Builder#createHouse()
	 */
	@Override
	public House createHouse() {
		return house;
	}

}
