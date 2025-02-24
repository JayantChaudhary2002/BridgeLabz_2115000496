import java.lang.reflect.*;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodCall {
    public static void main(String[] args) throws Exception {
        MathOperations obj = new MathOperations();
        Method method = MathOperations.class.getMethod("add", int.class, int.class);
        System.out.println(method.invoke(obj, 10, 20));
    }
}
