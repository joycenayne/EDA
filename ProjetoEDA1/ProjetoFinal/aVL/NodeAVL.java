package aVL;

public class NodeAVL<Chave, G> {
	private NodeAVL<Chave, G> esq, dir;
	private int altura; 
	private Chave chave;
	private G object;
	
	public NodeAVL(Chave chave, G object) {
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

	public NodeAVL<Chave, G> getEsq() {
		return esq;
	}

	public void setEsq(NodeAVL<Chave, G> esq) {
		this.esq = esq;
	}

	public NodeAVL<Chave, G> getDir() {
		return dir;
	}

	public void setDir(NodeAVL<Chave, G> dir) {
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
