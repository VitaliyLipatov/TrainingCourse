import java.util.ArrayList;
import java.util.Collections;

interface MyFunc<T> {
    MyClass<T> func(T n);
}

public class MyClass<T> {
    private T val;

    MyClass(T v) {
        val = v;
    }

    public MyClass() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc<Integer> classConst = MyClass<Integer>::new;
        MyClass<Integer> mc = classConst.func(1000);
        System.out.println(mc.getVal());
    }
}

