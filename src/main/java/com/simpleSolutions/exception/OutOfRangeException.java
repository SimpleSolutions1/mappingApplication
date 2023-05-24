package com.simpleSolutions.exception;

import java.util.List;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(List<Integer> numberList, int max, int min) {
        super("Numbers " + numberList +" is greather then "+max+ "or less then " + min);
    }
}
