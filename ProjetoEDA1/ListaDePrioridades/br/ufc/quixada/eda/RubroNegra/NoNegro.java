package br.ufc.quixada.eda.RubroNegra;

public class NoNegro <G> {
	private NoNegro<G> esq = null, dir = null;
	private int chave;
	private boolean cor;
	
	public static final boolean preto = true;
	public static final boolean vermelho = false;
	
	private G elemento;
	
	public NoNegro(int chave, G elemento){
		this.chave = chave;
		this.elemento = elemento;		
	}

	public NoNegro<G> getEsq() {
		return esq;
	}

	public void setEsq(NoNegro<G> esq) {
		this.esq = esq;
	}

	public NoNegro<G> getDir() {
		return dir;
	}

	public void setDir(NoNegro<G> dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public G getElemento() {
		return elemento;
	}

	public void setElemento(G elemento) {
		this.elemento = elemento;
	}

	public static boolean isPreto() {
		return preto;
	}

	public static boolean isVermelho() {
		return vermelho;
	}	

}
