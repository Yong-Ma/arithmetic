package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 懒汉式
 * 可解决浪费内存空间的问题
 * 但是这个在多线程下无法保证对象是单例的，可以用加锁来解决
 * 反射可破坏单例
 * 有相应的应对策略
 */
public class LazyMan_3 {
    //私有构造器
    private LazyMan_3() {
        //第一个被注释掉的if可以防止反射破坏单例，但如果都是用反射获得对象，不经过正规途径，仍然会破坏，可加个标志flag来解决,但这个标志仍然可以被人通过反编译破解
        synchronized (LazyMan_3.class) {
//            if(lazyMan!=null)
//                throw new RuntimeException("不要视图用反射破坏单例");
            if(flag==false)
                flag=true;
            else
                throw new RuntimeException("不要视图用反射破坏单例");
        }
    }
    //加个标志位
    private static boolean flag=false;

    private static volatile LazyMan_3 lazyMan;

    public static LazyMan_3 getInstance() {
        if(lazyMan ==null) {
            synchronized (LazyMan_3.class) {
                if(lazyMan ==null)
                    lazyMan = new LazyMan_3();
            }
        }
        return lazyMan;
    }
    //使用反射破坏了单例
    public static void main(String[] args) throws Exception {
        //LazyMan instance1=LazyMan.getInstance();
        //使用反射获得构造器
        Constructor<LazyMan_3> declaredConstructor = LazyMan_3.class.getDeclaredConstructor(null);
        Field flag = LazyMan_3.class.getDeclaredField("flag");
        flag.setAccessible(true);
        declaredConstructor.setAccessible(true);//设置可访问私有
        LazyMan_3 instance2=declaredConstructor.newInstance();
        flag.set(instance2,false);//破坏单例
        LazyMan_3 instance1=declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);

    }
}
