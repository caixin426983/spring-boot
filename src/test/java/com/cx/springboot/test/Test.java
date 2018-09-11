package com.cx.springboot.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {


    public static void test1()  {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // 复现方法一
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
//                arrayList.remove(integer);
                iterator.remove();
            }
        }

//        // 复现方法二
//        iterator = arrayList.iterator();
//        for (Integer value : arrayList) {
//            Integer integer = iterator.next();
//            if (integer.intValue() == 5) {
//                arrayList.remove(integer);
//            }
//        }
    }

    public static void main(String[] args) {


        test1();

    }


}
