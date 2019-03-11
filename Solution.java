import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gameWithCells function below.
     */
    static int gameWithCells(int n, int m) {
        if(m ==0 || n==0) {
            return 0;
        }
        if(m%2 ==0 && n%2 ==0){
            return (n*m)/4;
        }
        if(m%2 ==0 || n%2 ==0){
            if(m%2 == 0) {
                return gameWithCells(n-1, m)+m/2;
            } else{
                return gameWithCells(n, m-1)+n/2;
            }

        }
        int ans = (n*m)/2;
        double an = (n*m*1.0)/2;;
        if(an > ans) {
            return ans+1;
        }
        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       // String[] nm = scanner.nextLine().split(" ");

        //int n = Integer.parseInt(nm[0].trim());

        //int m = Integer.parseInt(nm[1].trim());

        int result = gameWithCells(70, 123);
        System.out.println("------"+result);

    }
}
