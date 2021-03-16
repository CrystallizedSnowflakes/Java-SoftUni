package a03highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static class MethodComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        try {
            Method[] declaredMethods = clazz.getDeclaredMethods();

            Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
            Set<Method> getters = new TreeSet<>(new MethodComparatorByName());
            Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

            for (Method m : declaredMethods) {
                if (m.getName().contains("get") && m.getParameterCount() == 0
                        && m.getReturnType() != void.class){

                    getters.add(m);
                }else if (m.getName().contains("set") && m.getParameterCount() == 1
                        && m.getReturnType() == void.class){

                    setters.add(m);
                }
            }

            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            fields.stream()
                    .filter(f ->! Modifier.isPrivate(f.getModifiers()))
                    .sorted(Comparator.comparing(Field::getName))
                    .forEach(f -> System.out.println(f.getName() + " must be private!"));

            getters.stream()
                    .filter(g -> !Modifier.isPublic(g.getModifiers()))
                    .sorted((Comparator.comparing(Method::getName)))
                    .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

            setters.stream()
                    .filter(s -> !Modifier.isPrivate(s.getModifiers()))
                    .sorted((Comparator.comparing(Method::getName)))
                    .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
