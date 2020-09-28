public class OverLoadRide {
    public static void main(String[] args) {
        A a = new A();
        a.print();

        B b = new B();
        b.print();

        ((A) b).print();
    }

    private static class A {
        int mInt = 1;

        void print() {
            System.out.println(mInt);
        }

        static void add() {

        }
    }

    private static class B extends A {

        int mInt = 2;

        void print() {
            System.out.println(mInt);
        }
    }

    public interface IA {
        int add();
    }

    public interface IB {
        int a = 1;

        void add();

        default void plus() {

        }
    }

    public static abstract class AbsClass{

    }
}
