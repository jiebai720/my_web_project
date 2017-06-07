package com.bb;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bj on 2017-06-07.
 */
public class Test {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World!");
        list.stream().forEach(System.out::println);
    }



}
