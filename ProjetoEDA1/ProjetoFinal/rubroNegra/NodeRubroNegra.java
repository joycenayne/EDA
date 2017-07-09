package rubroNegra;

import rubroNegra.NodeRubroNegra;

public class NodeRubroNegra <G> {
	private NodeRubroNegra<G> esq = null, dir = null;
	private int chave;
	private boolean cor;
	private G elemento;
	
	public static final boolean preto = true;
	public static final boolean vermelho = false;	
	
	public NodeRubroNegra(int chave, G elemento){
		this.chave = chave;
		this.elemento = elemento;		
	}

	public NodeRubroNegra<G> getEsq() {
		return esq;
	}

	public void setEsq(NodeRubroNegra<G> esq) {
		this.esq = esq;
	}

	public NodeRubroNegra<G> getDir() {
		return dir;
	}

	public void setDir(NodeRubroNegra<G> dir) {
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
