package br.ufc.quixada.eda.AVL;


public class AVL<Chave extends Comparable<Chave>, G>{
		
		private NoAVL<Chave, G> raiz = null;
		
		public void inserir(Chave chave, G object){
			this.raiz = inserir(this.raiz, chave, object);
		}
		
		private NoAVL<Chave, G> inserir(NoAVL<Chave, G> raiz, Chave chave, G object){
			if(raiz == null){
				raiz = new NoAVL<Chave, G>(chave, object);
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

		private int altura(NoAVL<Chave,G> raiz){
			return raiz == null ? -1 : raiz.getAltura();
		}

		private NoAVL<Chave, G> rotEsq(NoAVL<Chave,G> raiz) {
			NoAVL<Chave, G> aux = raiz.getDir();
			raiz.setDir(aux.getEsq());
			aux.setEsq(raiz);
			raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
			aux.setAltura(max(altura(aux.getDir()), raiz.getAltura()) + 1);
			return aux;
		}
		

		private NoAVL<Chave, G> rotDir(NoAVL<Chave, G> raiz) {
			NoAVL<Chave, G> aux = raiz.getEsq();
			raiz.setEsq(aux.getDir());
			aux.setDir(raiz);
			raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
			aux.setAltura(max(altura(aux.getEsq()), raiz.getAltura()) + 1);
			return aux;
		}

		private NoAVL<Chave, G> rotDEsq(NoAVL<Chave, G> raiz){
			raiz.setDir(rotDir(raiz.getDir()));
			return rotEsq(raiz);
		}

		private NoAVL<Chave, G> rotDDir(NoAVL<Chave, G> raiz){
			raiz.setEsq(rotEsq(raiz.getEsq()));
			return rotDir(raiz);
		}

		private int comp(NoAVL<Chave, G> raiz){
			return altura(raiz.getEsq()) - altura(raiz.getDir());
		}
		
		private NoAVL<Chave, G> vBalance(NoAVL<Chave, G> raiz){
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
		
		public NoAVL<Chave, G> remove(NoAVL<Chave, G> no, Chave chave){
			if(no == null)
				return null;
			int cmp = chave.compareTo(no.getChave());
			if(cmp == 1){
				no.setDir(remove(no.getDir(), chave));
				if((altura(no.getEsq()) - altura(no.getDir())) == 2){
					if(altura(no.getEsq().getEsq()) > altura(no.getEsq().getDir())){
						no = rotDir(no);
					}else{
						no = rotDDir(no);
					}
				}
			}else if(cmp == -1){
				no.setEsq(remove(no.getEsq(), chave));
				if((altura(no.getDir()) - altura(no.getEsq())) == 2){
					if(altura(no.getDir().getDir()) > altura(no.getDir().getEsq())){
						no = rotEsq(no);
					}else{
						no = rotDEsq(no);
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
					NoAVL<Chave,G> aux = pegar_menor(no.getDir());
					no.setChave(aux.getChave());
					no.setDir(remove(no.getDir(), aux.getChave()));
				}
			}
			no.setAltura(((altura(no.getDir()) > altura(no.getEsq())) ? altura(no.getDir()) : (altura(no.getEsq()))) + 1);
			return no;
		}
		
		private NoAVL<Chave,G> pegar_menor(NoAVL<Chave,G> noAVL){
			NoAVL<Chave,G> aux = noAVL;
			while(aux.getEsq() != null)
				aux = aux.getEsq();
			return aux;
		}
		
		private void mostraArvore(NoAVL<Chave, G> n, String s) {
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

		public NoAVL<Chave, G> getRaiz() {
			return raiz;
		}

		public void setRaiz(NoAVL<Chave, G> raiz) {
			this.raiz = raiz;
		}
}
