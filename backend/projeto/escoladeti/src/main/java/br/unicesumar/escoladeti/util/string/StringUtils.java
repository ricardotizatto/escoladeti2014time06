package br.unicesumar.escoladeti.util.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return str != null && !str.equals("");
    }

    public static boolean onlyLetters(String str) {
        Pattern padrao = Pattern.compile("[A-Za-z\\s]+");
        Matcher pesquisa = padrao.matcher(str);
        if (pesquisa.matches()) {
            return true;
        }else{
            return false;
        }

    }
}
