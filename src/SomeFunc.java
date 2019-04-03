public interface SomeFunc<T> {
    T getValue(T t);
}

class GenerationFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeFunc<Integer> factorial = integer -> {
            int result = 1;
            for (int i = 1; i <= integer; i++ ){
                result*= i;
            }
            return result;
        };
        System.out.println(factorial.getValue(5));

        SomeFunc<String> reverse = str -> {
            StringBuilder result = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--){
                result.append(str.charAt(i));
            }
            return result.toString();
        };
        System.out.println(reverse.getValue("Джава"));
    }
}
