package br.unicesumar.escoladeti.enums;

public enum TraducaoMaterial {
	BRAILLE,
	MECDAISY,
	DOSVOX,
	OUTRO;

	public static TraducaoMaterial of(String traducaoMaterial) {
		try {
			return valueOf(traducaoMaterial);
		} catch (Exception e) {
			throw new RuntimeException("Tradução do material inválido");
		}
	}
}
