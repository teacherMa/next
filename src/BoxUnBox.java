public class BoxUnBox {
    public static void main(String[] args) {
//        int a = 1;
//        int b = 1;
//        System.out.println(a == b);
//
//        Integer c = 1;
//        Integer d = 1;
//        System.out.println(c == d);
//
//        Integer e = new Integer(1);
//        Integer f = new Integer(1);
//        System.out.println(e == f);
//
//        int g = 233;
//        Integer h = 233;
//        System.out.println(g == h);
//        System.out.println(h == g);
//        System.out.println(h.equals(g));

//        /*
//         * true
//         * true
//         * false
//         * false
//         * false
//         * false
//         */

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;


        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
