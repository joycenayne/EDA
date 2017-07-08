package br.ufc.quixada.eda.hash;

public abstract class Hash {
	protected Integer m = 0;
	
	protected Integer fHash(Integer chave){
		return (chave % m);
	}
	
	public abstract void inserir(Integer chave, String valor) throws Except;
	
	public abstract String buscar(Integer chave);
	
	public abstract String remover(Integer chave);
	
	public Hash(Integer tam){
		m = tam;
	}

}
