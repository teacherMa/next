public class JavaInherited {
    public static void main(String[] args) {

    }

    abstract static class A {
        int a;

        public A(int a) {
            this.a = a;
        }

        static void print() {

        }
    }

    static class B extends A {

        public B(int a) {
            super(a);
        }
    }

    interface I1{

    }

    interface I2 extends I1 {

    }
}
