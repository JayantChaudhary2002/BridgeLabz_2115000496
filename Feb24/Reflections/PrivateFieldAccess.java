import java.lang.reflect.*;

class Person {
    private int age = 25;
}

public class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 30);
        System.out.println(field.get(person));
    }
}
