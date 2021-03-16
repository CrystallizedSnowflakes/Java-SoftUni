package a01reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;
        System.out.println("class " + clazz.getSimpleName());

        Class<? super Reflection> baseClass = clazz.getSuperclass(); // wildCard
        System.out.println("class " + baseClass.getName());

        Arrays.stream(clazz.getInterfaces())
                .forEach(i -> System.out.println("interface " + i.getName()));

        try {
            Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
            Reflection reflection = ctor.newInstance();
            System.out.println(reflection.toString());
        } catch (NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
