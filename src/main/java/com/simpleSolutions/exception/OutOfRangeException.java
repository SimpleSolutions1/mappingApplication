package com.simpleSolutions.exception;

import java.util.List;

public class OutOfRangeException extends Exception {
    public OutOfRangeException(List<Integer> numberList, int max, int min) {
        super("Numbers is greather then "+max+ "or less then " + min);
    }
}
