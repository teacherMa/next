/**
 * 静态代码块优于普通代码块，普通代码块优于构造函数。static变量的声明和赋值也可以看作静态代码块，静态代码块的执行顺序由代码的顺序决定。
 */
public class LoadOrder {

    private static final LoadOrder sLoadOrder2 = new LoadOrder("");

    static {
        System.out.println(0);
    }

    private static LoadOrder sLoadOrder = new LoadOrder();

    static {
        System.out.println(1);
    }

    {
        System.out.println(2);
    }

    public LoadOrder() {
        System.out.println(4);
    }

    public LoadOrder(String i) {
        System.out.println(3);
    }

    public static void main(String[] args) {
        System.out.println(5);
    }
}
