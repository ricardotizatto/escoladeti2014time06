package br.unicesumar.escoladeti.util.number;

import java.util.Calendar;

public class NumberUtils {

    public static boolean isBiggerThanZero(Number num) {
        return num != null && num.doubleValue() > 0;
    }

    public static boolean isYearValid(Long ano) {
        return ano <= Calendar.getInstance().get(Calendar.YEAR);
    }

    public static boolean isNumber(String termo) {
        return termo.matches("\\d");
    }
}
