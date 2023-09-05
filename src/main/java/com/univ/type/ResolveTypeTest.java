package com.univ.type;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 要站在较高的维度了解（不用深入细节）：有了此类，便能知道某个字段、方法入参、方法出参关于类型的所有信息，如父类、泛型、实现的接口等等；
 * 常见方法(用来获取ResolveType类型)：
 *  ResolvableType.forField
 *  ResolvableType.forMethodParameter
 *  ResolvableType.forMethodReturnType
 *
 *
 * @author univ
 * date 2023/9/5
 */
public class ResolveTypeTest<T> {

    private HashMap<Integer, List<String>> myMap;

    private String str;

    private Integer integer;

    private List<?> list;

    private T generic;

    public static void main(String[] args) throws NoSuchFieldException {
        printField(ResolveTypeTest.class.getDeclaredField("myMap"));
        printField(ResolveTypeTest.class.getDeclaredField("str"));
        printField(ResolveTypeTest.class.getDeclaredField("integer"));
        printField(ResolveTypeTest.class.getDeclaredField("list"));
        printField(ResolveTypeTest.class.getDeclaredField("generic"));
    }

    public static void printField(Field field) {
        System.out.println("===start===");
        System.out.println("处理的字段名称为: " + field.getName());
        ResolvableType t = ResolvableType.forField(field);
        System.out.println("getSuperType(): " + t.getSuperType());
        System.out.println("getInterfaces(): " + Arrays.toString(t.getInterfaces()));
        System.out.println("getGenerics(): " + Arrays.toString(t.getGenerics()));
        System.out.println("getGeneric(0).resolve(): " + t.getGeneric(0).resolve());
        System.out.println("getGeneric(1).resolve(): " + t.getGeneric(1).resolve());
        System.out.println("===end===");
        System.out.println();
    }
}
