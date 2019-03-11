import javax.swing.*;
import java.sql.SQLOutput;

public class LongestPalendromeSequence {

    public static void main(String... a) {

        String str = "character";
        System.out.println("Ans - ");
        String ans = "";
        System.out.println(getLongestSequence(str.toCharArray(),0,str.length()-1,ans));
    }

    private static String getLongestSequence(char[] ch, int a, int b, String ans) {
        if(a > b) {
            return "";
        }
        if(a == b) {
            return ""+ch[a];
        }

        if(ch[a] == ch[b]) {
            ans = ans+ch[a] +getLongestSequence(ch, a+1,b-1,ans) + ch[a];

        } else {
            String str1 = getLongestSequence(ch, a+1,b,ans);
            String str2 = getLongestSequence(ch, a,b-1,ans);
            if(str1.length() > str2.length()) {
                ans = str1;
            } else{
                ans = str2;
            }
        }
        return ans;
    }
}
