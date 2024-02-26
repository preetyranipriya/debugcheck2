package com.ht.debugcheck2.code;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Calc1 implements ICalc {

    public Double add(int a, int b) {
        return (double) (a+b);
    }

    @Override
    public Double divide(int a, int b) {




        return (double) ((double)a/(double) b);
    }
}
