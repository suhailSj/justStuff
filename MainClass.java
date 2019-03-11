public class MainClass {

    public static void main(String ...a ) {
        String[] arr = function1(true);
    }

    private static String[] function1(boolean var) {
        String[] arr = new String[]{};
        if(var) {
            arr = function2();
        } else{
            arr = function3();
        }
        return arr;
    }

    public static String[] function2() {
        return new String[]{};
    }

    public static String[] function3() {
        return new String[]{};
    }
}
