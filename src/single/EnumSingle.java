package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举是单例的，反射也不能破坏其单例
 */
public enum  EnumSingle {
    INSTANCE;
    public  static EnumSingle getInstance() {
        return INSTANCE;
    }
}
class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle enum1=EnumSingle.getInstance();
        EnumSingle enum2=EnumSingle.getInstance();
        System.out.println(enum1==enum2);

        //尝试用反射破坏单例性
        //Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);//会报错，没有无参构造器
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);//报错：Cannot reflectively create enum objects
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle1 = declaredConstructor.newInstance();
        EnumSingle enumSingle2 = declaredConstructor.newInstance();
        System.out.println(enumSingle1==enumSingle2);
    }
}
