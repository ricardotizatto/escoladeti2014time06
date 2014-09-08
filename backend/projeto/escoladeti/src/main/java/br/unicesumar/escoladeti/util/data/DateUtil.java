package br.unicesumar.escoladeti.util.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int actualYear() {
		return now().get(Calendar.YEAR);
	}

	public static Calendar now() {
		return Calendar.getInstance();
	}
        
        public static boolean validDate(Date data){
            Date hoje = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            if(f.format(hoje).equals(f.format(data)) || data.after(hoje)){    
                return true;
            }else{
                return false;
            }
        }
        
        public static boolean validBeforeDate(Date data){
            Date hoje = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            if(f.format(hoje).equals(f.format(data)) || data.before(hoje)){    
                return true;
            }else{
                return false;
            }
        }
        //verifica se ano é maior que o ano atual
        public static boolean validYear(Date ano){
            Date hoje = new Date();
            SimpleDateFormat f = new SimpleDateFormat("yyyy");
            if(f.format(hoje).equals(f.format(ano)) || ano.after(hoje)){    
                return true;
            }else{
                return false;
            }
        }
}
