package annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class AnnotationHandle {
    public static void main(String[] args) {
        AnnotationHandle h = new AnnotationHandle();
        h.handle(AnRequest.class);
        h.handle(AnRequestImpl.class);
        h.handle(AnRequestImplImpl.class);
    }

    private void handle(Class<?> c) {
        System.out.println(c.getName());
        Retrofit retrofit = c.getAnnotation(Retrofit.class);
        System.out.println(c.isAnnotationPresent(Retrofit.class));
        if (retrofit != null) {
            System.out.println(c.getName());
        }
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            Request r = m.getAnnotation(Request.class);
            if (r != null) {
                System.out.println(m.getName());
                Parameter[] parameters = m.getParameters();
                for (Parameter p : parameters) {
                    Query q = p.getAnnotation(Query.class);
                    if (q != null) {
                        System.out.println(q.value());
                    }
                }
            }
        }

    }


}
