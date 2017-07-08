package br.ufc.quixada.eda.RubroNegra;

public class RubroNegra<G> {
private NoNegro<G> raiz;
	
	public boolean isPreto(NoNegro<G> no){
		if(no == null) return true;
		else if(no.isCor() == NoNegro.isPreto()) return true;
		else return false;
	}
	
	private void recolor(NoNegro<G> no){
		no.setCor(NoNegro.isVermelho());
		no.getEsq().setCor(NoNegro.isPreto());
		no.getDir().setCor(NoNegro.isPreto());
	}
	
	private NoNegro<G> rotacaoDireita(NoNegro<G> no){
		NoNegro<G> novoNo = no.getEsq();
		no.setEsq(novoNo.getDir());
		novoNo.setDir(no);
		return novoNo;
	}
	private NoNegro<G> rotacaoEsquerda(NoNegro<G> no){
		NoNegro<G> novoNo = no.getDir();
		no.setDir(novoNo.getEsq());
		novoNo.setEsq(no);
		return novoNo;
	}
	
	public void inserir (int chave, G elemento){
		raiz = inserir(raiz, chave, elemento);
		raiz.setCor(NoNegro.isPreto());
	}

	public NoNegro<G> inserir(NoNegro<G> raiz, int chave, G elemento){
		if(raiz == null){
			NoNegro<G> no = new NoNegro<>(chave, elemento);
			return no;
		}
		
		if(chave < raiz.getChave()) 
			raiz.setEsq(inserir(raiz.getEsq(), chave, elemento));
		else if(chave > raiz.getChave()) 
			raiz.setDir(inserir(raiz.getDir(), chave, elemento));
		
		if(isPreto(raiz) && !isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq()))
			recolor(raiz);
		else if(isPreto(raiz) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir()))
			recolor(raiz);
		
		if(isPreto(raiz) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(NoNegro.isPreto());
			raiz.getDir().setCor(NoNegro.isVermelho());
		}else if(isPreto(raiz) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())){
			raiz = rotacaoEsquerda(raiz);
			raiz.setCor(NoNegro.isPreto());
			raiz.getEsq().setCor(NoNegro.isVermelho());
		}
		
		if(!isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getDir())){
			raiz.setEsq(rotacaoEsquerda(raiz.getEsq()));
		}else if(!isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getEsq())){
			raiz.setDir(rotacaoDireita(raiz.getDir()));			
		}
		return raiz;
	}
	
	public NoNegro<G> busca(int chave){
		NoNegro<G> no = busca(chave, raiz);
		return no;
	}
	
	public NoNegro<G> busca(int chave, NoNegro<G> no){
		if(no == null || no.getChave() == chave)
			return no;
		if(no.getChave() > chave)
			return busca(chave, no.getEsq());
		return busca(chave, no.getDir());
	}
	
	private void mostraArvore(NoNegro<G> n, String s) {
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
		System.out.print(n.getChave());
		if(n.isCor())
			System.out.println(" P");
		else
			System.out.println(" v");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			mostraArvore(n.getEsq(), s + "l");
		}
	}
	
	public void mostraArvore(){
		System.out.println("\n");
		mostraArvore(raiz, " ");
		System.out.println("\n");
	}

}
