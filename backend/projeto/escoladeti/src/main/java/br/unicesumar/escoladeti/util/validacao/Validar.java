package br.unicesumar.escoladeti.util.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
    
    public static boolean validaEmail(String email) {
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{1,7}$");
        Matcher m = p.matcher(email);
        if(m.find()) {
            return true;
        } else {
            return false;
        }
    }
}
