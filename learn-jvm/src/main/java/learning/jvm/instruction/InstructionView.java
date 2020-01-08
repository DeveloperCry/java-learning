package learning.jvm.instruction;

/**
 * 测试查看JVM指令
 * 先run了之后才能用这个功能查看
 * View -> Show Bytecode
 */
public class InstructionView {
    public static void main(String[] args) {
        int a = 2;
        int b = 0;
        Object o = new Object();
        System.out.println("a = " + a + ", b = " + b);
    }
}
