package other;

import java.util.ArrayList;

public class JVMDemo {
    byte[] byteArray = new byte[1*1024*1024]; //1M = 1024K
    public static void main(String[] args) {
        ArrayList<JVMDemo> list = new ArrayList<>();
        int count = 0;
        try {
            while (true){
                list.add(new JVMDemo());
                count = count + 1;
            }
        }catch (Error e){
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
