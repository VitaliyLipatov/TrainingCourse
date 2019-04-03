
class Stats<T extends java.lang.Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> ob) {
        return ob.average() == average();
    }
}

class StatsDemo {
    public static void main(String[] args) {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double v = iob.average();
        System.out.println(v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        double w = dob.average();
        System.out.println(w);

        System.out.println(iob.sameAvg(dob));
    }
}

class GenMethDemo {

    private static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5, 6};
        System.out.println(isIn(100, nums));
        String string[] = {"one", "two", "three"};
        System.out.println(isIn("two", string));
    }
}

class GenCons {
    private double val;

    <T extends java.lang.Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }
}

class GenConsDemo {
    public static void main(String[] args) {
        GenCons test = new GenCons(100);
        GenCons test2 = new GenCons(1001L);
        test.showVal();
        test2.showVal();
    }
}

interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}

class MinMaxDemo<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    public MinMaxDemo(T[] vals) {
        this.vals = vals;
    }

    public T min() {
        T v = vals[0];
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) v = vals[i];
        }
        return v;
    }

    public T max() {
        T v = vals[0];
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) v = vals[i];
        }
        return v;
    }
}
class GenIFDemo{
    public static void main(String[] args) {
        Integer inums[] = {2, 5, 90, 100};
        Character chrs[] = {'r', 's', 't', 'w'};

        MinMaxDemo<Integer> integerMinMaxDemo = new MinMaxDemo<>(inums);
        MinMaxDemo<Character> characterMinMaxDemo = new MinMaxDemo<>(chrs);
        System.out.println(integerMinMaxDemo.max());
        System.out.println(characterMinMaxDemo.min());
    }
}
class GenGen<T>{
    T ob;

    public GenGen(T ob) {
        this.ob = ob;
    }

    T getOb(){
        return ob;
    }
}

class GenGen2<T> extends GenGen<T>{

    public GenGen2(T ob) {
        super(ob);
    }
}
class HierDemo{
    public static void main(String[] args) {
        GenGen2<Integer> iob = new GenGen2<>(99);
        GenGen<Integer> iob2 = new GenGen<>(88);
        GenGen2<String> strob = new GenGen2<>("test");
        if (iob instanceof GenGen<?>){
            System.out.println("iob is GenGen");
        }
        System.out.println();
        if (strob instanceof GenGen2<?>){
            System.out.println("strob is GenGen2");
        }
        if (iob2 instanceof GenGen2<?>){
            System.out.println("doesn't display");
        }
    }
}
class GenericMethodDemo{
    static <T, V extends T> boolean arraysEquals(T[] x, V[] y){
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++){
            if (!x[i].equals(y[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {0, 1, 2, 3};
        Integer[] nums2 = {3, 1, 2, 3};
        Integer[] nums3 = {0, 1, 2, 3};
        Integer[] nums4 = {0, 1, 2, 3, 5};

        System.out.println(arraysEquals(nums1, nums3));
        System.out.println(arraysEquals(nums1, nums2));
        System.out.println(arraysEquals(nums3, nums4));
    }
}