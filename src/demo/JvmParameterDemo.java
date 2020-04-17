package demo;

/**
 * @Author: heyong
 * @Date: 2020-01-19 16:17
 * @Description:
 */
public class JvmParameterDemo {

    public static void main(String[] args) {
        byte[] b = new byte[10 * 1024 * 1024];
        System.out.println("分配了10M空间给数组");
        System.gc();
        // 最大可分配给JVM内存
        System.out.println("Xmx=:" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0 + "M");
        // 已经分配给JVM但是空闲的内存
        System.out.println("freeMemory=:" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024.0 + "M");
        // 已经分配给JVM的内存
        System.out.println("totalMemory=:" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024.0 + "M");
    }
}
