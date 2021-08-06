package bishi;

interface Animal{
    public void createAnimal();
}
interface Plant{
    public void createPlant();
}
class Horse implements Animal{
    public void createAnimal(){
        System.out.println("马");
    }
}
class Cow implements Animal{
    public void createAnimal(){
        System.out.println("牛");
    }
}
class vegetables implements Plant{
    public void createPlant(){
        System.out.println("菜");
    }
}
class fruit implements Plant{
    public void createPlant(){
        System.out.println("水果");
    }
}
public abstract class AbsFactory {
    public abstract void newAnimal();
    public abstract void newPlant();
}
class GuangzhouFarm extends AbsFactory{

    @Override
    public void newAnimal() {
        Animal  cow=new Cow();
        cow.createAnimal();
    }

    @Override
    public void newPlant() {
        Plant vegetables=new vegetables();
        vegetables.createPlant();
    }
}
class BeiJingFarm extends AbsFactory{

    @Override
    public void newAnimal() {
        Animal  horse=new Horse();
        horse.createAnimal();
    }

    @Override
    public void newPlant() {
        Plant fruit=new fruit();
        fruit.createPlant();
    }
}
