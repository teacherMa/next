package singleton;

public class SingletonUltra {
    // 静态内部类，直接解决所有问题
    private SingletonUltra() {
    }

    private static class Holder {
        private static SingletonUltra sInstance = new SingletonUltra();
    }

    public static SingletonUltra getInstance() {
        return Holder.sInstance;
    }
}
