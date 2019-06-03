/**
 * 
 */
package learning.jvm.reload;

/**
 * @author Xiong.Liu
 *
 */
public class User {

    public String execute() throws InterruptedException {
//        return ask();
        return say();
    }
    
    public String say() {
        return "I am saying";
    }
    
    public String ask() {
        return "I am asking";
    }

}
