import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    public static class Notification {
        private int chanel;
        private int importent;

        public Notification() {
            System.out.println("no param");
        }

        public Notification(int chanel, int importent) {
            System.out.println("two param");
            this.chanel = chanel;
            this.importent = importent;
            System.out.println(getClass().getName());
        }

        void build() {

        }

        public void show() {

        }
    }

    public static void main(String[] args) {
        try {
            Class<Notification> aClass = (Class<Notification>) Class.forName("Reflect$Notification");
            Notification n = (Notification) aClass.newInstance();
            Method[] methods = aClass.getMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }
            Field[] fields = aClass.getFields();
            for (Field f : fields) {
                System.out.println(f.getName());
            }
            Constructor<Notification> constructor = aClass.getConstructor(int.class, int.class);
            constructor.newInstance(1, 1);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
