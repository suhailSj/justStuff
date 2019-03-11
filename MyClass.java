public class MyClass{
    public static void main(String args[]){
        MyThreadClass t1=new MyThreadClass("odd", 1000);
        MyThreadClass t2=new MyThreadClass("Even", 1000);
        t1.start();
        t2.start();
    }
    public static class MyThreadClass extends Thread {
        String type;
        int max;
        MyThreadClass(String type, int max) {
            this.max = max;
            this.type = type;
        }
        public void run() {
            if(this.type.equals("odd")) {
                Thread.currentThread().setName("ODD Thread");
                OddEven odd = new OddEven();
                odd.printOdd(this.max);
            } else {
                Thread.currentThread().setName("Even Thread");
                OddEven even = new OddEven();
                even.printEven(this.max);
            }
        }
    }



    public static class OddEven {
        static boolean isOddPrinted = false;
        static Object obj = new Object();
        public  void printOdd (int max) {
            int i = 1;
            while(i < max) {
                synchronized(obj) {
                    if(isOddPrinted) {
                        try {
                            obj.wait();
                        } catch(Exception e) {e.printStackTrace();}
                    }
                    System.out.println("odd " + i);
                    i = i+2;
                    isOddPrinted = true;
                    obj.notify();
                }
             }
        }
        public  void printEven(int max) {
            int i = 2;
            while(i < max) {
                synchronized(obj) {
                    if(!isOddPrinted) {
                        try {
                            obj.wait();
                        } catch(Exception e) {e.printStackTrace();}
                    }
                    System.out.println("Even " + i);
                    i = i+2;
                    isOddPrinted = false;
                    obj.notify();
                }
            }
        }
    }
}

