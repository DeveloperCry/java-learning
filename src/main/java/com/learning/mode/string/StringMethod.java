/**
 * 
 */
package com.learning.mode.string;

/**
 * @author Xiong.Liu
 *
 */
public class StringMethod {

    /**
     * 
     */
    public StringMethod() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "chrisliu";
        String b = new String("chrisliu");
        String c = "chris" + "liu";
        
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
        System.out.println(a.intern() == c.intern());
        System.out.println(a.intern());
        System.out.println(b.intern());

    }

}
