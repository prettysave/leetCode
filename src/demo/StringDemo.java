package demo;

/**
 * @author: heyong
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "ABCD  　";
        String s2 = "ABCD  ";

        String s3 = "ABCD  ";
        char[] chars = s1.toCharArray();
        System.out.println(chars);

        boolean equals = s2.equals(s3);
        System.out.println(equals);


        for (int i = 1; i < 31; i++) {
            String str = "";
            if (i < 10) {
                str = str + "0" + i;
            } else {
                str += i;
            }
            System.out.println("alter table ctm_product_season_sale drop partition p202004" + str + ";");
        }

    }
}
