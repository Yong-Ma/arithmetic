package single;

//使用静态内部类来实现单例
//仍然是不安全的，运用反射可使其单例被破坏
public class StaticInnerSingle {
    private StaticInnerSingle() {}


    public static StaticInnerSingle getInstance() {
        return innerClass.staticInnerSingle;
    }

    public static class innerClass{
        private static StaticInnerSingle staticInnerSingle=new StaticInnerSingle();
    }
}
