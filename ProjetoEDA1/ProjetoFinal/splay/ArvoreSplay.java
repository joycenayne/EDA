package splay;

public class ArvoreSplay<Chave extends Comparable<Chave>, G> {
	private NodeSplay<Chave, G> raiz;
	
	private NodeSplay<Chave, G> splay(NodeSplay<Chave, G> raiz, Chave chave ){
		if(raiz == null) return null;
		if(raiz.getChave() == chave) return raiz;
		
		if(chave.compareTo(raiz.getChave()) < 0){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaoDireita(raiz);
			}
		}else {
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaoEsquerda(raiz);
			}
		}
		
		return raiz;
	}
	
	public void inserir(Chave chave, G object){
		raiz = inserir(raiz, chave, object);
	}
	
	private NodeSplay<Chave, G> inserir(NodeSplay<Chave, G> raiz, Chave chave, G object){
		if(raiz == null)
			return new NodeSplay<Chave, G>(chave, object);
		else if(raiz.getChave().compareTo(chave) > 0 ){
			raiz.setEsq(inserir(raiz.getEsq(), chave, object));
		}else if(raiz.getChave().compareTo(chave) < 0){
			raiz.setDir(inserir(raiz.getDir(), chave, object));
		}
		raiz = splay(raiz, chave);
		return raiz;
	}
	
	private NodeSplay<Chave, G> rotacaoDireita(NodeSplay<Chave, G> no){
		NodeSplay<Chave, G> novoNo = no.getEsq();
		no.setEsq(novoNo.getDir());
		novoNo.setDir(no);
		return novoNo;
	}
	private NodeSplay<Chave, G> rotacaoEsquerda(NodeSplay<Chave, G> no){
		NodeSplay<Chave, G> novoNo = no.getDir();
		no.setDir(novoNo.getEsq());
		novoNo.setEsq(no);
		return novoNo;
	}
	
	public NodeSplay<Chave, G> busca(Chave chave){
		raiz = splay(raiz, chave);
		if(raiz.getChave() == chave)
			return raiz;
		else
			return null;
	} 
	
	public void remover(Chave chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NodeSplay<Chave, G> aux = splay(this.raiz.getEsq(), chave);
		if(raiz.getDir() != null && aux != null) aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	private void mostraArvore(NodeSplay<Chave, G> n, String s) {
		if(n != null && (n.getEsq() != null || n.getDir() != null))
			mostraArvore(n.getDir(), s + "r");
		int tam = s.length();
		for(int i = 0; i < tam - 1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				System.out.print("| "+"  ");
			}else {
				System.out.print("  "+"  ");
			}
		}
		if(s != "") {
			if(s.endsWith("r") == true)
				System.out.print("┌───");
			else
				System.out.print("└───");
		}
		if(n == null) {
			System.out.println("#");
			return;
		}
		System.out.println(n.getChave());
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			mostraArvore(n.getEsq(), s + "l");
		}
	}
	
	public void mostraArvore() {
		mostraArvore(this.raiz, "");
		System.out.println("\n\n");
	}
}
