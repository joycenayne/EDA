package br.ufc.quixada.eda.AVL;

public class NoAVL<Chave, G> {
	
	private NoAVL<Chave, G> esq, dir;
	private int altura; 
	private Chave chave;
	private G object;
	
	public NoAVL(Chave chave, G object){
		esq = null;
		dir = null;
		altura = 1;
		this.chave = chave;
		this.object = object;
	}

	public G getObject() {
		return object;
	}

	public void setObject(G object) {
		this.object = object;
	}

	public NoAVL<Chave, G> getEsq() {
		return esq;
	}

	public void setEsq(NoAVL<Chave, G> esq) {
		this.esq = esq;
	}

	public NoAVL<Chave, G> getDir() {
		return dir;
	}

	public void setDir(NoAVL<Chave, G> dir) {
		this.dir = dir;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}
}
