import java.io.IOException;

public class ExceptionAndError {
    public static void main(String[] args) {
        //add();
        add2();

        try {
            add3();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        try {
            try {
                add3();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw new IOException("123");
            }
        } catch (IOException e) {
            // do nothing
        }


    }

    private static void add() throws RuntimeException {
        throw new RuntimeException();
    }

    public static int test() {
        try {
            add();
            return 1;
        } catch (Exception e) {
            add();
            return 1;
        } finally {
            return 2;
        }

    }

    static {
        System.out.println(test());
    }

    private static void add2() throws Error {

    }

    private static void add3() throws Throwable {
    }
    static abstract class a{
        abstract void sss();
    }

    static {
        try(MyClose close = new MyClose();
        YouClose close2 = new YouClose();
        MyClose myClose = new MyClose();
        ) {
            myClose.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyClose implements AutoCloseable {

        public MyClose() {
            System.out.println("create");
        }

        @Override
        public void close() throws Exception {
            System.out.println("close");
        }
    }

    private static class YouClose implements AutoCloseable {
        public YouClose() {
            System.out.println("You Close create");
            throw new RuntimeException("");
        }

        @Override
        public void close() throws Exception {
            System.out.println("You Close Close");
        }
    }
}
