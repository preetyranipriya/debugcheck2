package com.ht.debugcheck2.code;

import org.springframework.stereotype.Component;

@Component
public class Calc2 implements ICalc{

    public Double add(int a, int b) {


            throw new RuntimeException("Don't use this add method. Use the Calc1 class");

    }

    public Double divide(int a, int b){
        return (double) (a/b);
    }
}
