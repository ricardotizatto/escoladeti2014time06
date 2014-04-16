package br.unicesumar.escoladeti.util.tostring;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.style.ToStringCreator;

public class ToStringUtil {

	static final Logger logger = LoggerFactory.getLogger(ToStringUtil.class);

	public static String toString(Object target) {
		ToStringCreator toStringCreator = new ToStringCreator(target, new EntidadeStyler());
		
		for (Field field : getNonStaticFields(target.getClass())) {
			field.setAccessible(true);
			
			try {
				toStringCreator.append(field.getName(), field.get(target));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.debug("Problema no toString()", e);
			}
		}
		
		return toStringCreator.toString().replace("[ ", "[");
		
	}

	private static ArrayList<Field> getNonStaticFields(Class<?> aClass) {
		if (aClass.equals(Object.class))
			return new ArrayList<>();
		
		ArrayList<Field> fields = getNonStaticFields(aClass.getSuperclass());
		
		for (Field field : aClass.getDeclaredFields()) {
			if (!Modifier.isStatic(field.getModifiers()))
				fields.add(field);
		}
		
		return fields;
	}
}
