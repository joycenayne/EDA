package br.ufc.quixada.eda.grafo;

public class Grafo {
	private int qtdVertice;
	private int qtdAresta;
	private Aresta arestas[];
	private ListaAdjacencia adj[];
	
	public Grafo(int a, int b){
		qtdVertice = a;
		qtdAresta = b;
	}

	public int getQtdVertice() {
		return qtdVertice;
	}

	public void setQtdVertice(int qtdVertice) {
		this.qtdVertice = qtdVertice;
	}

	public int getQtdAresta() {
		return qtdAresta;
	}

	public void setQtdAresta(int qtdAresta) {
		this.qtdAresta = qtdAresta;
	}
	
	public Aresta[] getArestas(){
		return arestas;
	}
	
	public void setArestas(Aresta[] arestas){
		this.arestas = arestas;
	}
	
	public void add (Aresta a){
		arestas[arestas.length] = a;
	}
	public void quickSort(int i, int j){
		if (i < j){
			int k = particiona(i , j);
			quickSort(i, k - 1);
			quickSort(k + 1, j);
		}
	}
	
	public int particiona(int i, int j){
		int pivo = j;
		int a = i - 1;
		for(int p = i; p < j; p++){
			if(arestas[p].getCusto() < arestas[pivo].getCusto()){
				a++;
				Aresta aux = arestas[p];
				arestas[p] = arestas[a];
				arestas[a] = aux;
			}
		}
		
		Aresta aux = arestas[a + 1];
		arestas[a + 1] = arestas[j];
		arestas[j] = aux;
		return a +1;
	}
	
	public ListaAdjacencia[] getAdj(){
		return adj;
	}
	
	public void setAdj(ListaAdjacencia[] adj){
		this.adj = adj;
	}
}
