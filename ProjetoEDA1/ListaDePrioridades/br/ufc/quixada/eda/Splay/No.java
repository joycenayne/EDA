package br.ufc.quixada.eda.Splay;

public class No<Chave, G> {
		
		private No<Chave, G> dir, esq;
		private Chave chave;
		private G object;
		
		public No(Chave chave, G object){
			esq = null;
			dir = null;
			this.chave = chave;
			this.object = object;
		}
		
		public No<Chave, G> getDir() {
			return dir;
		}
		public void setDir(No<Chave, G> no) {
			this.dir = no;
		}
		public No<Chave, G> getEsq() {
			return esq;
		}
		public void setEsq(No<Chave, G> no) {
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
