/**
 * 
 */
package learning.mode.builder;

/**
 * @author Xiong.Liu
 *
 */
public class Engineer {
	public void conduct(Builder builder) {
		builder.buildFoundation();
		builder.buildWall();
		builder.buildRoof();
		builder.buildDoor();
		builder.buildWindow();
	}
}
