
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Staircase {

    public static void main(String ...a) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int n = Integer.parseInt(br.readLine());
        //int x= Integer.parseInt(br.readLine());
        int[] arr = new int[]{2,5,7};
        staircase(n, arr);
    }

    private static void staircase(int n, int[] arr) {
        /*
        n - 9
        arr - {2,5,7}
         */
        int[] num = new int[n+1];
        num[0] = 1;
        //num[1] = 1;
        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        map.put(0, list);
        //map.put(1, list);
        for(int i=1; i<=n;i++) {
            int total = 0;
            map.put(i, new ArrayList<String>());


            for(int j : arr) {
                if(i-j>=0) {
                    total += num[i-j];
                    ArrayList<String> li = map.get(i-j);
                    ArrayList<String> list1 = new ArrayList<String>(li);
                    for(String s : list1){
                        s=s+"-" +j;
                        map.get(i).add(s);
                    }

                }

            }
            num[i] = total;
      }

        System.out.println("*******************************");
        System.out.println(num[n]);
        System.out.println(map.get(n));

        System.out.println("*******************************");
    }

}
