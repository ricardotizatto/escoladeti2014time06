package br.unicesumar.escoladeti.util.data;

import java.util.Calendar;

public class DateUtil {

	public static int actualYear() {
		return now().get(Calendar.YEAR);
	}

	public static Calendar now() {
		return Calendar.getInstance();
	}

}
