public interface MyNumber {
    double getValue();
}

interface NumericTest {
    boolean getValue2(int n);
}

interface NumericTest2 {
    boolean test(double n, double m);
}

class Numbers {
    public static void main(String[] args) {
        MyNumber myNum;
        myNum = () -> 123.45;
        System.out.println(myNum.getValue());
        myNum = () -> Math.random() * 100;
        System.out.println(myNum.getValue());
        NumericTest isEven = n -> (n % 2) == 0;
        NumericTest isNonNeg = n -> (n > 0);
        if (isEven.getValue2(10)) System.out.println("Even");
        if (isNonNeg.getValue2(1)) System.out.println("Non-negative");
        NumericTest2 isFactor = (n, m) -> (n % m) == 0;
        if (isFactor.test(10.0, 3.0)) System.out.println("Множители");
    }
}
