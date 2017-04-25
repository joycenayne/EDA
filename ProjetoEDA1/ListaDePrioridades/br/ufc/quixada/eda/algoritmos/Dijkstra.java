package br.ufc.quixada.eda.algoritmos;


import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	
	private int origem;
	private int antecessor[] = null;
	private int custo[] = null;
	private int vertices[] = null;
	
	
	public void Execucao(Grafo grafo){
		int n = grafo.getQtdVertice();
		antecessor = new int[n];
		custo = new int[n];
		vertices = new int[n];
		
		Inicializacao(n, origem);

		HeapMinimo Q = new HeapMinimo(grafo.getQtdVertice());
		Q.construir(vertices);
		
		while(!Q.isEmpty()){
			int u = Q.remove();
			ListaAdjacencia adj = grafo.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta aresta = adj.next();
				int v = (aresta.getU() == u ? aresta.getV() : aresta.getU());
				Relaxamento(adj, u, v);
			}
		}
	}
	
	public void Inicializacao(int v, int s){
		for(int u = 0; u < v; u++){
			antecessor[u] = -1;
			custo[u] = Integer.MAX_VALUE;
			vertices[u] = u;
		}
		
		antecessor[origem] = 0;
		custo[origem] = origem;
	}
	
	public void Relaxamento(ListaAdjacencia adj, int u, int v){
		if(custo[v] > (custo[u] + adj.next().getCusto())){
			antecessor[v] = u;
			custo[v] = custo[u] + adj.next().getCusto();
		}
		adj.next();
	}
	
	public void ImprimeResultado(int origem, int v){
		if(origem == v){
			System.out.println(origem);
		}else if(antecessor[v] == -1){
			System.out.println("Não há caminho da" + origem + "até" + v);
		}else{
			System.out.println(v);
		}
	}
}
