package demo;


import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: heyong
 * @Date: 2019-12-16 15:18
 * @Description:
 */
public class ListNullDemo {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.size());

        for (Object object : list){
            System.out.println("进循环了");
            object.toString();
        }

    }
}
