package single;

/**
 * 饿汉式
 * 存在一个问题：饿汉式一上来就加载所有的东西，那么可能会浪费空间
 * 可以用懒汉式解决这个问题，直到使用的时候才加载
 */

public class HungryMan {
    //私有构造器
    private HungryMan() {}
    //立马加载这个类
    private static  final HungryMan hungryMan=new HungryMan();
    //向外部提供的公有方法，外部可通过这个方法来获得这个单例对象
    public static HungryMan getInstance() {
        return hungryMan;
    }
}
