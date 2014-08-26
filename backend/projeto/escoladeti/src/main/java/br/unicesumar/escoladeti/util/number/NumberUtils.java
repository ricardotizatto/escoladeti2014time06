
package br.unicesumar.escoladeti.util.number;

public class NumberUtils {
    public static boolean isBiggerThanZero(Number num){
        return num != null && num.doubleValue() > 0;
    }
}
