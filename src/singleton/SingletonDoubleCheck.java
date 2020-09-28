package singleton;

public class SingletonDoubleCheck {
    // 高效率的加锁的懒汉式
    private SingletonDoubleCheck() {
    }

    private static SingletonDoubleCheck sSingletonDoubleCheck;

    public static SingletonDoubleCheck getInstance() {
        if (sSingletonDoubleCheck == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (sSingletonDoubleCheck == null) {
                    sSingletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }
        return sSingletonDoubleCheck;
    }
}
