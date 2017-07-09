package aVL;

public class ArvoreAVL<Chave extends Comparable<Chave>, G> {
	private NodeAVL<Chave, G> raiz = null;
	
	public void inserir(Chave chave, G object){
		this.raiz = inserir(this.raiz, chave, object);
	}
	
	private NodeAVL<Chave, G> inserir(NodeAVL<Chave, G> raiz, Chave chave, G object){
		if(raiz == null){
			raiz = new NodeAVL<Chave, G>(chave, object);
		}else if(raiz.getChave().compareTo(chave) > 0){
			raiz.setEsq(inserir(raiz.getEsq(), chave, object));
		}else if(raiz.getChave().compareTo(chave) < 0){
			raiz.setDir(inserir(raiz.getDir(),chave, object));
		}
		raiz = vBalance(raiz);
		return raiz;
	}
	
	private int max(int dir, int esq){
		return dir > esq ? dir : esq;
	}

	private int altura(NodeAVL<Chave, G> raiz){
		return raiz == null ? -1 : raiz.getAltura();
	}

	private NodeAVL<Chave, G> rotacaoEsq(NodeAVL<Chave, G> raiz) {
		NodeAVL<Chave, G> aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getDir()), raiz.getAltura()) + 1);
		return aux;
	}
	

	private NodeAVL<Chave, G> rotacaoDir(NodeAVL<Chave, G> raiz) {
		NodeAVL<Chave, G> aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getEsq()), raiz.getAltura()) + 1);
		return aux;
	}

	private NodeAVL<Chave, G> rotacaoDuplaEsq(NodeAVL<Chave, G> raiz){
		raiz.setDir(rotacaoDir(raiz.getDir()));
		return rotacaoEsq(raiz);
	}

	private NodeAVL<Chave, G> rotacaoDuplaDir(NodeAVL<Chave, G> raiz){
		raiz.setEsq(rotacaoEsq(raiz.getEsq()));
		return rotacaoDir(raiz);
	}

	private int comp(NodeAVL<Chave, G> raiz){
		return altura(raiz.getEsq()) - altura(raiz.getDir());
	}
	
	private NodeAVL<Chave, G> vBalance(NodeAVL<Chave, G> raiz){
		if(comp(raiz) == 2){
			if(comp(raiz.getEsq()) > 0){
				raiz = rotacaoDir(raiz);
			}else{
				raiz = rotacaoDuplaDir(raiz);
			}
		}else if (comp(raiz) == -2){
			if(comp(raiz.getDir()) < 0){
				raiz = rotacaoEsq(raiz);
			}else{
				raiz = rotacaoDuplaEsq(raiz);
			}
		}else{
			
		}
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		return raiz;
	}
	
	private void mostraArvore(NodeAVL<Chave, G> n, String s) {
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
		System.out.println(n.getChave() +"(" + n.getAltura()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			mostraArvore(n.getEsq(), s + "l");
		}
	}
	
	public void remover(Chave chave){
		raiz = remove(raiz, chave);
	}
	
	public NodeAVL<Chave, G> remove(NodeAVL<Chave, G> no, Chave chave){
		if(no == null)
			return null;
		int cmp = chave.compareTo(no.getChave());
		if(cmp == 1){
			no.setDir(remove(no.getDir(), chave));
			if((altura(no.getEsq()) - altura(no.getDir())) == 2){
				if(altura(no.getEsq().getEsq()) > altura(no.getEsq().getDir())){
					no = rotacaoDir(no);
				}else{
					no = rotacaoDuplaDir(no);
				}
			}
		}else if(cmp == -1){
			no.setEsq(remove(no.getEsq(), chave));
			if((altura(no.getDir()) - altura(no.getEsq())) == 2){
				if(altura(no.getDir().getDir()) > altura(no.getDir().getEsq())){
					no = rotacaoEsq(no);
				}else{
					no = rotacaoDuplaEsq(no);
				}
			}
		}else{
			if(no.getDir() == null || no.getEsq() == null){
				if(no.getDir() == null && no.getDir() == null)
					return null;
				if(no.getDir() == null){
					no = no.getEsq();
				}else{
					no = no.getDir();
				}
			}else{
				NodeAVL<Chave, G> aux = pegar_menor(no.getDir());
				no.setChave(aux.getChave());
				no.setDir(remove(no.getDir(), aux.getChave()));
			}
		}
		no.setAltura(((altura(no.getDir()) > altura(no.getEsq())) ? altura(no.getDir()) : (altura(no.getEsq()))) + 1);
		return no;
	}
	
	private NodeAVL<Chave, G> pegar_menor(NodeAVL<Chave, G> no){
		NodeAVL<Chave, G> aux = no;
		while(aux.getEsq() != null)
			aux = aux.getEsq();
		return aux;
	}
	
	public void mostraArvore() {
		mostraArvore(this.raiz, "");
		System.out.println("\n\n");
	}

	public NodeAVL<Chave, G> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodeAVL<Chave, G> raiz) {
		this.raiz = raiz; 
	}

	public NodeAVL<Chave, G> busca(Chave chave){
		return busca(chave, raiz);
	}
	
	private NodeAVL<Chave, G> busca(Chave chave, NodeAVL<Chave, G> objeto) {
		if(objeto == null){
			return null;
		}
		if(chave.compareTo(objeto.getChave()) > 0){
			busca(chave, objeto.getDir());
		}else if (chave.compareTo(objeto.getChave()) < 0){
			busca(chave, objeto.getEsq());
		}
		return objeto;
	}
}
