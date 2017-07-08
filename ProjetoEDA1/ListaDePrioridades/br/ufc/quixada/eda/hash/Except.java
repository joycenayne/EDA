package br.ufc.quixada.eda.hash;

public class Except extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public Except(String mensagem) {
		super(mensagem);
	}
}
