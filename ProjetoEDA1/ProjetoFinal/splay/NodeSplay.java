package splay;

public class NodeSplay <Chave, G> {
	private NodeSplay<Chave, G> dir, esq;
	private Chave chave;
	private G object;
		
	public NodeSplay(Chave chave, G object){
		esq = null;
		dir = null;
		this.chave = chave;
		this.object = object;
	}
		
	public NodeSplay<Chave, G> getDir() {
		return dir;
	}
	
	public void setDir(NodeSplay<Chave, G> no) {
		this.dir = no;
	}
	
	public NodeSplay<Chave, G> getEsq() {
		return esq;
	}
		
	public void setEsq(NodeSplay<Chave, G> no) {
		this.esq = no;
	}
		
	public Chave getChave() {
		return chave;
	}
		
	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public G getObject() {
		return object;
	}
	
	public void setObject(G object) {
		this.object = object;
	}
}
