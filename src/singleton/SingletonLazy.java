package singleton;

public class SingletonLazy {
    // 懒汉式

    private static SingletonLazy mSingle;

    private SingletonLazy() {
    }

    public static void getInstance() {
        if (mSingle == null) {
            mSingle = new SingletonLazy();
        }
    }
}
