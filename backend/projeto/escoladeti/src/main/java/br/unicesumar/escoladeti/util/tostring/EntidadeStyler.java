package br.unicesumar.escoladeti.util.tostring;

import org.springframework.core.style.DefaultToStringStyler;
import org.springframework.core.style.DefaultValueStyler;

public class EntidadeStyler extends DefaultToStringStyler {

	public EntidadeStyler() {
		super(new DefaultValueStyler());
	}

	@Override
	public void styleStart(StringBuilder buffer, Object obj) {
		buffer.append(obj.getClass().getSimpleName()).append('[');
	}
}
