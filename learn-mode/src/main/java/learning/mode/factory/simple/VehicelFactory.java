/**
 * 
 */
package learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 *
 */
public class VehicelFactory extends Creator{

	/* (non-Javadoc)
	 * @see Creator#createVehicle(java.lang.Class)
	 */
	@Override
	public <T extends Vehicle> T createVehicle(Class<T> vehicleClass) {
		Vehicle vehicle = null;
		try {
			vehicle = (Vehicle)Class.forName(vehicleClass.getName()).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (T)vehicle;
	}

}
