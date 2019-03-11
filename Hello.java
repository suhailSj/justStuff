import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Hello {


    public static char[] s = new String("Being").toCharArray();
    public static void main(String []args){
        reverse( 0, new String("Being").length()-1);
        System.out.println("----"+new String(s));

    }

    public static void reverse( int i, int j) {
        if (j== i) {
            return;}

            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            reverse(i + 1, j - 1);

    }
}
