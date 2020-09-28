import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        GenericClass<? extends Double> doubleGenericClass = new GenericClass<>();

        GenericInterface genericInterface = new GenericInterfaceImpl();
        // Exception：java.lang.Integer cannot be cast to java.lang.String
        // genericInterface.print(1);

        GenericInterface<String> stringGenericInterface = new GenericInterfaceImpl();
        stringGenericInterface.print("1");

        GenericClass2 genericClass2 = new GenericClass2<>();
        Class<?> c = genericClass2.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType());
        }

        c = doubleGenericClass.getClass();
        fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType());
        }

        Generic generic = new Generic();
        generic.useBox();
    }

    private static class GenericClass<T> {
        private T mParam;

        void print() {
            System.out.println("GenericClass " + mParam);
        }
    }

    private static class GenericClass2<T extends RuntimeException> {
        private T mParam;

        void print() {
            System.out.println("GenericClass " + mParam);
        }
    }

    private static <T> void genericMethod(T input) {
        System.out.println("GenericMethod " + input);
    }

    private interface GenericInterface<T> {
        void print(T input);
    }

    private static class GenericInterfaceImpl implements GenericInterface<String> {
        @Override
        public void print(String input) {
            System.out.println("GenericInterfaceImpl " + input);
        }
    }

    private static class GenericInterfaceImpl2 implements GenericInterface<Object> {

        @Override
        public void print(Object input) {

        }
    }

    private void useBox() {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());


        Box<Fruits> fruitsBox = new Box<>();
        System.out.println();

        BoxTake<Fruits> fruitsBoxTake = new BoxTake<>();
        System.out.println(fruitsBoxTake.getClass().getName());
        fruitsBoxTake.take(appleBox);

        List<Fruits> fruits = new ArrayList<>();
        fruits.add(new Apple());
    }

    private class Fruits {

    }

    private class Apple extends Fruits {

    }

    private class Peach extends Fruits {

    }

    private class Box<T> {
        List<T> mElements = new ArrayList<>();

        void add(T t) {
            mElements.add(t);
        }

        List<T> getAll() {
            return mElements;
        }
    }

    private class BoxTake<T> {
        T take(Box<? extends T> box) {
            if (box.getAll() == null || box.getAll().isEmpty()) {
                return null;
            }
            return box.getAll().get(0);
        }

        T put(Box<? super T> box, T t) {
            if (box.getAll() == null) {
                return null;
            }
            box.getAll().add(t);
            return t;
        }
    }
}
