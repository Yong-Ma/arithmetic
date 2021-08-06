package single;

/**
 * 懒汉式
 * 可解决浪费内存空间的问题
 * 但是这个在多线程下无法保证对象是单例的，可以用加锁来解决
 *
 */
public class LazyMan_2 {
    //私有构造器
    private LazyMan_2() {
        System.out.println(Thread.currentThread().getName());
    }

    private static volatile LazyMan_2 lazyMan2;

    public static LazyMan_2 getInstance() {
        //双重检查加锁（DCL）
        //但是这样23行仍然存在问题
        if(lazyMan2 ==null) {
            synchronized (LazyMan_2.class) {
                if(lazyMan2 ==null)
                    lazyMan2 = new LazyMan_2();
                /**
                 * lazyMan= new LazyMan();这句不是原子性操作，操作如下
                 * 1.分配内存空间
                 * 2.执行构造器的内容，初始化对新
                 * 3.让对象指向这个空间
                 * 因为不是原子性操作，所以以上步骤可能存在被CPU指令重排
                 * 顺序从123可能变为132，那么此时如果进行到3时，变量lazyMan已经被分配了空间，
                 * 这时又有一个线程进来，它会判断lazyMan不为空，直接返回，但是这个变量里面却是空的
                 * 可以为这个变量加volatile修饰符，保证不会被重排
                 */
            }
        }
        return lazyMan2;
    }
    //测试多线程
    public static void main(String[] args) {
        //创建10个线程来测试懒汉式是否能保证单例
        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                LazyMan_2.getInstance();}).start();
        }
    }

}
