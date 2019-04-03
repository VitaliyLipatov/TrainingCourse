public class TwoGen<T, V> {
    T ob1;
    V ob2;

    public TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
    T getOb1(){
        return ob1;
    }
    V getOb2(){
        return ob2;
    }

    void showTypes(){
        System.out.println("T " + ob1.getClass().getName());
        System.out.println("V " + ob2.getClass().getName());
    }
}

class SimpGen{
    public static void main(String[] args) {
        TwoGen<Integer, String> tg = new TwoGen<Integer, String>(1001, "Java");
        tg.showTypes();

        int v = tg.getOb1();
        System.out.println(v);
        String str = tg.getOb2();
        System.out.println(str);
    }
}
