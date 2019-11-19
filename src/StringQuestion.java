import java.util.HashMap;
import java.util.Map;

public class StringQuestion {

    public static void main(String args[]){
        String s = "abba";
                int max = 0;
                int size = s.length();
                Map <Character,Integer> map = new HashMap<>();
                for(int i = 0, j = 0; j < size; j++){
                    char c = s.charAt(j);
                    if(map.containsKey(c)){
                        i = map.get(c) + 1;
                    }
                    map.put(c,j);
                    max = Math.max(max,j - i + 1);

                }
                System.out.println(max);
            }
}
