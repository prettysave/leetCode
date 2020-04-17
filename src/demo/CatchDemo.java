package demo;

/**
 * @Author: heyong
 * @Date: 2020-01-19 14:30
 * @Description:
 */
public class CatchDemo {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch!!");
        }
        System.out.println("catch 之后！！");
    }
}
