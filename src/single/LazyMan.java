package single;


/**
 * 懒汉式
 * 可解决浪费内存空间的问题
 */
public class LazyMan {
    //私有构造器
    private LazyMan() { }

    private static  LazyMan lazyMan;

    public static LazyMan getInstance() {
        if(lazyMan==null)
            lazyMan = new LazyMan();
        return lazyMan;
    }
}

