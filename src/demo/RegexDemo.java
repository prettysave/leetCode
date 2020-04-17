package demo;

import java.util.regex.Pattern;

/**
 * @Author: heyong
 * @Date: 2020-01-14 12:41
 * @Description:
 */
public class RegexDemo {

    public static void main(String[] args) {
        String s = "aAaaaaaa";
        boolean matches = Pattern.matches("(?=^.{8,16}$)(?=.*\\d)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", s);
        System.out.println(matches);

    }
}
