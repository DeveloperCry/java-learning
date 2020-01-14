/**
 * 
 */
package learning.mode.extend;

/**
 * @author Xiong.Liu
 *
 */
public class Parent extends Grandfather {

    public Parent() {
        super();
        System.out.println(this.getClass().getCanonicalName());
        System.out.println("This is a parent");
    }
}
