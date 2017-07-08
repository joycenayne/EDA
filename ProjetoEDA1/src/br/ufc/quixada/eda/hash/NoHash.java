package br.ufc.quixada.eda.hash;

public class NoHash {
	private Integer chave;
	private String valor;
	private Integer prox;

	public NoHash(Integer chave, String valor){
		this.chave = chave;
		this.valor = valor;
		this.prox = -1;
	}
	
	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getProx() {
		return prox;
	}

	public void setProx(Integer prox) {
		this.prox = prox;
	}

}