package a02gettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class MethodComparatorByName implements Comparator<Method>{

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        try {
            Method[] declaredMethods = clazz.getDeclaredMethods();

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

            System.out.println(
                    getters.stream().map(g -> String.format("%s will return class %s",
                            g.getName(), g.getReturnType().getName().replace("class", "")))
                    .collect(Collectors.joining(System.lineSeparator()))
            );

            System.out.println(
                    setters.stream().map(s -> String.format("%s and will set field of class %s",
                            s.getName(), s.getParameterTypes()[0].getName().replace("class", "")))
                            .collect(Collectors.joining(System.lineSeparator()))
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
