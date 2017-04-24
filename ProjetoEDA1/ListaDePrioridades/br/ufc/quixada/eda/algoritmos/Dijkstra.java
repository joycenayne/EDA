package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	
	private int antecessor[] = null;
	private double custo[] = null;
	
	public void Execucao(Grafo grafo, int origem){
		
		List<Integer> vertices =  new ArrayList<>();
		int n = grafo.getQtdVertice();
		antecessor = new int[n];
		custo = new double[n];
		
		
		for(int i = 0; i < n; i++){
			custo[i] = Double.MAX_VALUE;
			antecessor[i] = -1;
			vertices.add(i);
		}
		
		antecessor[origem] = 0;
		custo[origem] = origem;


		HeapMinimo heap = new HeapMinimo(grafo.getQtdVertice());
		heap.construir(vertices);
		
		while(!heap.isEmpty()){
			int u = heap.remove();
			ListaAdjacencia adj = grafo.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta aresta = adj.next();
				int v = (aresta.getU() == u ? aresta.getV() : aresta.getU());
				if(custo[v] > (custo[u] + adj.next().getCusto())){
					antecessor[v] = u;
					custo[v] = adj.next().getCusto() + custo[u];
				}
				adj.next();
			}
		}
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
