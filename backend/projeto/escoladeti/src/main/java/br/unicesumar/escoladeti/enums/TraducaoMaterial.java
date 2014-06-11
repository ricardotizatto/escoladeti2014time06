package br.unicesumar.escoladeti.enums;

public enum TraducaoMaterial {
	BRAILLE("Braille"),
	MECDAISY("Mecdaisy"),
	DOSVOX("Dosvox"),
	OUTRO("Outros");
	
	private String name;
	
	private TraducaoMaterial(String name) {
		this.name = name;
	}
}
