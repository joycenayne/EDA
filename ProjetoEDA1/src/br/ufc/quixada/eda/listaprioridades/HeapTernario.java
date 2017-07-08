package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridades usando Heap Ternário.
 * 
 * @author joyce
 * @author barbara
 * 
 **/

public class HeapTernario{
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
		
	public HeapTernario(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
		
	private void subir(int i){
		int j = (i - 2)/3;
		
		if(j < 0){
			int pai = j*(-1);
			j = pai;
		}
		if(j >= 0){
			if(vetor[i] > vetor[j]){
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				
				subir(j);
			}
		}
	}
		
	private void descer(int i){
		int j = 3*i;
		
		if(j <= n){
			if(j + 1 < n && vetor[j] < vetor[j + 1]){
				j++;
			}
			if(vetor[i] < vetor[j]){
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				
				descer(j);
			}
		}
	}
		
	public void construir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		
		for(int j = n/2; j >= 0; j--){
			descer(j);
		}
	}
		
	public int getMaximaPrioridade(){
		if(n > 0){
			return vetor[0];
		}
		return 0;
	}
		
	public int remove(){
		if(n > 0){
			int aux = vetor[0];
			vetor[0] = vetor[n - 1];
			n--;
			descer(0);
			return aux;
		}
		return 0;
	}	
		
	public void inserir(int prioridade){
		if(n != nMaximo){
			vetor[n] = prioridade;
			n++;
			subir(n - 1);
		}
	}
		
	public void alterarPrioridade(int prioridade, int novaPrioridade){		
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				
				if(novaPrioridade > prioridade){
					subir(i);
				}
				else{
					descer(i);
				}
			}
		}
	}	
}
