public class Gen<T> {
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println(" " + ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<Integer>(100);
        iOb.showType();

        int v = iOb.getOb();
        System.out.println("Value " + v);
        System.out.println();

        Gen<String> iOb2 = new Gen<String>("Java");
        iOb2.showType();
        String str = iOb2.getOb();
        System.out.println("Value " + str);
    }
}
