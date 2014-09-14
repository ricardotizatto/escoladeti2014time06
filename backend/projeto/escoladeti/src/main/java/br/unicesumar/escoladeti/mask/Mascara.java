/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.mask;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Walber
 */
public class Mascara {

    public static String cpf(String valor) {
        String pattern = "###.###.###-##";
        MaskFormatter mask;
        String mascarado = null;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            mascarado = mask.valueToString(valor);
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mascarado;
    }

    public static String cpnj(String valor) {
        String pattern = "##.###.###/####-##";
        MaskFormatter mask;
        String mascarado = null;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            mascarado = mask.valueToString(valor);
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mascarado;

    }

}
