public interface StringFunc {
    String func(String str);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}

class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Java drives the Web!!!";
        String outStr;
        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println(inStr);
        System.out.println(outStr);
    }
}

class BlockLambdaDemo {
    static String stringOp(StringFunc str, String string) {
        return str.func(string);
    }

    public static void main(String[] args) {
        String inStr = "Java drives the Web!!!";
        String outStr;

        outStr = stringOp(str -> str.toUpperCase(), inStr);
        System.out.println(outStr);

        outStr = stringOp(str -> {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, inStr);
        System.out.println(outStr);
    }
}

