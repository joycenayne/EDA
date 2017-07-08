package br.ufc.quixada.eda.AVL;

public class NoAVL<G> {
	private NoAVL<G> esq, dir;
	private int altura, chave;
	private G object;
	
	public NoAVL(int chave, G object){
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

	public NoAVL<G> getEsq() {
		return esq;
	}

	public void setEsq(NoAVL<G> esq) {
		this.esq = esq;
	}

	public NoAVL<G> getDir() {
		return dir;
	}

	public void setDir(NoAVL<G> dir) {
		this.dir = dir;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
}
