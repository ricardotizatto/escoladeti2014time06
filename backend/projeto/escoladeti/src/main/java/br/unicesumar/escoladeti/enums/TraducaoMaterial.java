package br.unicesumar.escoladeti.enums;

public enum TraducaoMaterial {
	BRAILLE,
	MECDAISY,
	DOSVOX,
	OUTRO;

	public static TraducaoMaterial of(String traducaoMaterial) throws RuntimeException {
		try {
			return of(traducaoMaterial);
		} catch (Exception e) {
			throw new RuntimeException("Tradução do material inválido");
		}
	}
}
