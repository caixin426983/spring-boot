package com.cx.springboot.jvm;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFiled = Unsafe.class.getDeclaredFields()[0];
        unsafeFiled.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeFiled.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
