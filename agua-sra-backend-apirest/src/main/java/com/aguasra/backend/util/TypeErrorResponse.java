package com.aguasra.backend.util;

public enum TypeErrorResponse {
	
	CORRECT_RESPONSE(100,"OK"),
	ERROR_GENERIC(300,"Error Interno del servidor"),
	ERROR_DATABASE_CREATE(301,"Error al insertar en la base de datos"),
	ERROR_DATABASE_READ(302,"No se encuentra resultados en base de datos"),
	ERROR_DATABASE_UPDATE(303,"Error al actualizar en la base de datos"),
	ERROR_DATABASE_DELETE(304,"Error al eliminar en la base de datos");
	
	private final int value;

	private final String reasonPhrase;

	private TypeErrorResponse(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the reasonPhrase
	 */
	public String getReasonPhrase() {
		return reasonPhrase;
	}
	
	

}
