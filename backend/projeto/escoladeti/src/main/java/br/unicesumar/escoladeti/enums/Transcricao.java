package br.unicesumar.escoladeti.enums;

public enum Transcricao {
	BRAILLE,
	MECDAISY,
	DOSVOX,
	OUTRO;

	public static Transcricao of(String traducaoMaterial) {
		try {
			return valueOf(traducaoMaterial);

		} catch (Exception e) {
			throw new RuntimeException("Tradução do material inválido");
		}
	}
}
