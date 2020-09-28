package singleton;

public class SingletonDCWithVolatile {
    // 避免指令重排的高效率的加锁的懒汉式
    private SingletonDCWithVolatile() {
    }

    private volatile static SingletonDCWithVolatile sSingletonDCWithVolatile;

    public static SingletonDCWithVolatile getInstance() {
        if (sSingletonDCWithVolatile == null) {
            synchronized (SingletonDCWithVolatile.class) {
                if (sSingletonDCWithVolatile == null) {
                    sSingletonDCWithVolatile = new SingletonDCWithVolatile();
                }
            }
        }
        return sSingletonDCWithVolatile;
    }
}
