package singleton;

public class SingletonHungry {

    // 饿汉式

    private static SingletonHungry sMSingletonHungry = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return sMSingletonHungry;
    }
}
