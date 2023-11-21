package br.com.agenda.jdbc;

public class InsertException extends RuntimeException {
	
	public InsertException() {
		super("Wasn't possible insert credentials");
	}

}
