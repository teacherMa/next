package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducer {
    private static final int TIME = 20;
    private static final int ADD = 5;
    private static final int GET = 5;

    public static void main(String[] args) {
        ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();
        Repos repos;
//        repos = consumerAndProducer.new ReposNoConstraint();
//        repos = consumerAndProducer.new ReposWithSync();
//        repos = consumerAndProducer.new ReposWithLock();
//        repos = consumerAndProducer.new ReposWithAtomic();
        repos = consumerAndProducer.new ReposWithWait();
//        repos = consumerAndProducer.new ReposWithCondition();

        for (int i = 0; i < ADD; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Producer producer = consumerAndProducer.new Producer(repos);
                    producer.start();
                }
            }).start();
        }
        for (int i = 0; i < GET; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Consumer consumer = consumerAndProducer.new Consumer(repos);
                    consumer.start();
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("No Error");
                System.exit(0);
            }
        }).start();

    }

    public class Producer {
        Repos mRepos;

        public Producer(Repos repos) {
            mRepos = repos;
        }

        void start() {
            while (true) {
                mRepos.produce("Producer");
                try {
                    Thread.sleep((long) (Math.random() * TIME));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer {
        Repos mRepos;

        public Consumer(Repos repos) {
            mRepos = repos;
        }

        void start() {
            while (true) {
                try {
                    if (mRepos.getCount() > 0) {
                        mRepos.consume();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep((long) (Math.random() * TIME));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface Repos {
        void produce(String in);

        String consume();

        int getCount();
    }

    public class ReposNoConstraint implements Repos {
        private List<String> mData = new ArrayList<>();

        @Override
        public void produce(String in) {
            mData.add(in);
        }

        @Override
        public String consume() {
            if (mData.isEmpty()) {
                return "";
            }
            return mData.remove(0);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }

    public class ReposWithSync implements Repos {
        private List<String> mData = new ArrayList<>();

        private int mProduceSuccess = 0;
        private int mConsumeSuccess = 0;

        @Override
        public synchronized void produce(String in) {
            mProduceSuccess++;
            System.out.println("produce success " + mProduceSuccess);
            mData.add(in);
        }

        @Override
        public synchronized String consume() {
            if (mData.isEmpty()) {
                return "";
            }
            mConsumeSuccess++;
            System.out.println("consume success " + mConsumeSuccess);
            return mData.remove(0);
        }

        @Override
        public synchronized int getCount() {
            return mData.size();
        }
    }

    public class ReposWithLock implements Repos {
        private List<String> mData = new ArrayList<>();

        private Lock mLock = new ReentrantLock();

        private int mProduceSuccess = 0;
        private int mConsumeSuccess = 0;

        @Override
        public void produce(String in) {
            mLock.lock();
            mData.add(in);
            mProduceSuccess++;
            System.out.println("produce success " + mProduceSuccess);
            mLock.unlock();
        }

        @Override
        public String consume() {
            mLock.lock();
            if (!mData.isEmpty()) {
                String str = mData.remove(0);
                mConsumeSuccess++;
                System.out.println("consume success " + mConsumeSuccess);
                mLock.unlock();
                return str;
            }
            mLock.unlock();
            return "";
        }

        @Override
        public int getCount() {
            mLock.lock();
            int size = mData.size();
            mLock.unlock();
            return size;
        }

    }

    public class ReposWithAtomic implements Repos {
        private List<String> mData = new ArrayList<>();

        private AtomicInteger mUseFlag = new AtomicInteger(0);

        private int mProduceSuccess = 0;
        private int mConsumeSuccess = 0;

        @Override
        public void produce(String in) {
            while (mUseFlag.compareAndSet(0, 1)) {
                mData.add(in);
                mProduceSuccess++;
                System.out.println("produce success " + mProduceSuccess);
                mUseFlag.compareAndSet(1, 0);
                return;
            }
        }

        @Override
        public String consume() {
            while (mUseFlag.compareAndSet(0, 2)) {
                String str = "";
                if (!mData.isEmpty()) {
                    str = mData.remove(0);
                }
                mConsumeSuccess++;
                System.out.println("consume success " + mConsumeSuccess);
                mUseFlag.compareAndSet(2, 0);
                return str;
            }
            return "";
        }

        @Override
        public int getCount() {
            while (mUseFlag.compareAndSet(0, 3)) {
                int size = mData.size();
                mUseFlag.compareAndSet(3, 0);
                return size;
            }
            return 0;
        }
    }

    public class ReposWithWait implements Repos {
        private List<String> mData = new ArrayList<>();

        private final Object mMonitor = new Object();

        private int mProduceSuccess = 0;
        private int mConsumeSuccess = 0;

        @Override
        public void produce(String in) {
            synchronized (mMonitor) {
                mMonitor.notifyAll();
                mData.add(in);
                mProduceSuccess++;
                System.out.println("produce success " + mProduceSuccess);
                try {
                    mMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String consume() {
            synchronized (mMonitor) {
                mMonitor.notifyAll();
                while (mData.isEmpty()) {
                    try {
                        mMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mConsumeSuccess++;
                System.out.println("consume success " + mConsumeSuccess);
                return mData.remove(0);
            }
        }

        @Override
        public int getCount() {
            synchronized (mMonitor) {
                return mData.size();
            }
        }
    }

    public class ReposWithCondition implements Repos {
        public static final int SIZE = 100;
        private String[] mData = new String[SIZE];
        private int mCurrentPtr = 0;

        private Lock mLock = new ReentrantLock();
        private Condition mIsEmpty = mLock.newCondition();
        private Condition mIsFull = mLock.newCondition();

        private int mProduceSuccess = 0;
        private int mConsumeSuccess = 0;

        @Override
        public void produce(String in) {
            mLock.lock();
            while (mCurrentPtr == SIZE - 1) {
                try {
                    mIsFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mProduceSuccess++;
            mData[mCurrentPtr] = in;
            mCurrentPtr++;
            System.out.println("produce success " + mProduceSuccess + " currentPtr = " + mCurrentPtr);
            mIsEmpty.signalAll();
            mLock.unlock();
        }

        @Override
        public String consume() {
            mLock.lock();
            while (mCurrentPtr == 0) {
                try {
                    mIsEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String str = mData[mCurrentPtr - 1];
            mCurrentPtr--;
            mConsumeSuccess++;
            System.out.println("consume success " + mConsumeSuccess  + " currentPtr = " + mCurrentPtr);
            mIsFull.signalAll();
            mLock.unlock();
            return str;
        }

        @Override
        public int getCount() {
            mLock.lock();
            int size = mData.length;
            mLock.unlock();
            return size;
        }
    }
}
