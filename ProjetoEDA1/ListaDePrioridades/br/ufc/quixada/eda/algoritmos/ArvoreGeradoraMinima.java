package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.conjuntosdisjuntos.ConjuntosDisjuntos;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;

public class ArvoreGeradoraMinima {
	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntosDisjuntos conj = new ConjuntosDisjuntos(g.getQtdVertice());
		
		for(int i = 0; i < g.getQtdVertice(); i++){
			conj.make_set(i);
		}
		
		g.quickSort(0, g.getArestas().length - 1);
		
		for(int i = 0; i < g.getQtdAresta(); i++){
			Aresta a[] = g.getArestas();
			if(conj.find_set_fast(a[i].getV()) != conj.find_set_fast(a[i].getU())){
				solucao.add(a[i]);
				conj.union(a[i].getV(), a[i].getU());
			}
		}
		return solucao;
	}
	
	public double getCustoArvore(List<Aresta> solucao){
		double custo = 0;
		for(Aresta aresta : solucao){
			custo += aresta.getCusto();
		}
		return custo;
		
	}
}
