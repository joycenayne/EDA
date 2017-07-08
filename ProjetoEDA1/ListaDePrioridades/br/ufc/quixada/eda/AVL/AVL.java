package br.ufc.quixada.eda.AVL;

public class AVL<G> {
		
		private NoAVL<G> raiz = null;
		
		public void inserir(int chave, G object){
			this.raiz = inserir(this.raiz, chave, object);
		}
		
		private NoAVL<G> inserir(NoAVL<G> raiz, int chave, G object){
			if(raiz == null){
				raiz = new NoAVL<G>(chave, object);
			}else if(raiz.getChave() > chave){
				raiz.setEsq(inserir(raiz.getEsq(), chave, object));
			}else if(raiz.getChave() < chave){
				raiz.setDir(inserir(raiz.getDir(),chave, object));
			}
			raiz = vBalance(raiz);
			return raiz;
		}
		
		private int max(int dir, int esq){
			return dir > esq ? dir : esq;
		}

		private int altura(NoAVL<G> raiz){
			return raiz == null ? -1 : raiz.getAltura();
		}

		private NoAVL<G> rotEsq(NoAVL<G> raiz) {
			NoAVL<G> aux = raiz.getDir();
			raiz.setDir(aux.getEsq());
			aux.setEsq(raiz);
			raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
			aux.setAltura(max(altura(aux.getDir()), raiz.getAltura()) + 1);
			return aux;
		}
		

		private NoAVL<G> rotDir(NoAVL<G> raiz) {
			NoAVL<G> aux = raiz.getEsq();
			raiz.setEsq(aux.getDir());
			aux.setDir(raiz);
			raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
			aux.setAltura(max(altura(aux.getEsq()), raiz.getAltura()) + 1);
			return aux;
		}

		private NoAVL<G> rotDEsq(NoAVL<G> raiz){
			raiz.setDir(rotDir(raiz.getDir()));
			return rotEsq(raiz);
		}

		private NoAVL<G> rotDDir(NoAVL<G> raiz){
			raiz.setEsq(rotEsq(raiz.getEsq()));
			return rotDir(raiz);
		}

		private int comp(NoAVL<G> raiz){
			return altura(raiz.getEsq()) - altura(raiz.getDir());
		}
		
		private NoAVL<G> vBalance(NoAVL<G> raiz){
			if(comp(raiz) == 2){
				if(comp(raiz.getEsq()) > 0){
					raiz = rotDir(raiz);
				}else{
					raiz = rotDDir(raiz);
				}
			}else if (comp(raiz) == -2){
				if(comp(raiz.getDir()) < 0){
					raiz = rotEsq(raiz);
				}else{
					raiz = rotDEsq(raiz);
				}
			}else{
				
			}
			raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
			return raiz;
		}
		
		private void mostraArvore(NoAVL<G> n, String s) {
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
		
		public void mostraArvore() {
			mostraArvore(this.raiz, "");
			System.out.println("\n\n");
		}

		public NoAVL<G> getRaiz() {
			return raiz;
		}

		public void setRaiz(NoAVL<G> raiz) {
			this.raiz = raiz;
		}
}
