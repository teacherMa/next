package singleton;

public class SingletonSync {
    // 加锁的懒汉式
    private SingletonSync() {
    }

    private static SingletonSync sSingletonSync;

    public static SingletonSync getInstance() {
        synchronized (SingletonSync.class) {
            if (sSingletonSync == null) {
                sSingletonSync = new SingletonSync();
            }
        }
        return sSingletonSync;
    }
}
