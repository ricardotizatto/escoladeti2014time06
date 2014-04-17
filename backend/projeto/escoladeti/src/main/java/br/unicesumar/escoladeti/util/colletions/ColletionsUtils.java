package br.unicesumar.escoladeti.util.colletions;

import java.util.Collections;
import java.util.List;

public class ColletionsUtils {

	public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
		Collections.sort(list);
		return list;
	}

}
