package com.sk.userman.utils;

/**

 **/
public class BaseContext {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    private BaseContext(){}

    public static void set(String userId){
        threadLocal.set(userId);
    }

    public static String get(){
      return threadLocal.get();
    }
}
