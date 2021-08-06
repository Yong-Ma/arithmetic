package single;

public class single {
    private single(){
        synchronized (single.class){
            if(!flag)
                flag=true;
            else
                throw new RuntimeException("不要试图用反射破坏单例！");
        }
    }
    private static boolean flag;
    private static  volatile single single;
    public static single getInstance(){
        if(single==null){
            synchronized (single.class){
                if(single==null){
                    single=new single();
                }
            }
        }
        return single;
    }
}
