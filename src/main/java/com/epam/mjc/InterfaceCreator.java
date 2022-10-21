package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase(){
        return list -> list.stream().allMatch(word -> Character.isUpperCase(word.charAt(0))
                    && Character.isLetter(word.charAt(0)));
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            int size = integers.size();
            for (int i = 0; i < size; i++)
                if (integers.get(i) % 2 == 0)
                    integers.add(integers.get(i));
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
            return () -> values.stream().filter(str ->
                        Character.toUpperCase(str.charAt(0)) == str.charAt(0) &&
                        str.endsWith(".") &&
                        new StringTokenizer(str, " ").countTokens() > 3
                ).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list ->{
            Map<String, Integer> map = new HashMap<>();
            for (String str : list)
                map.put(str, str.length());
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
          List<Integer> newList = new ArrayList<>(list1);
          newList.addAll(list2);
          return newList;
        };
    }
}
