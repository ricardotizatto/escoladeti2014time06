package br.unicesumar.escoladeti.util.list;

import static java.lang.Long.parseLong;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	@SafeVarargs
	public static <T> List<T> toList(T... objects) {
		return new ArrayList<>(asList(objects));
	}
	
	public static List<Long> toIdList(List<String> idsString) {
		List<Long> idList = new ArrayList<>();
		
		for (String serieIdString : idsString) {
			idList.add(parseLong(serieIdString));
		}
		return idList;
	}

}
