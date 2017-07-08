package br.ufc.quixada.eda.listaprioridades;


/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMinimo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int ID[] = null;
	private int n = 0;
	
	public HeapMinimo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
		ID = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = (i - 1)/2;
		
		if(j >= 0){
			if(vetor[i] < vetor[j]){
				int aux1 = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux1;
				
				//Troca de lugar os IDs de acordo com a prioridade trocada.
				int aux2 = ID[i];
				ID[i] = ID[j];
				ID[j] = aux2;
				
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 2 * (i + 1);
		
		if(j <= n){
			j--;
			if(j + 1 < n && vetor[j] > vetor[j + 1]){
				j++;
			}
			if(vetor[i] > vetor[j]){
				int aux1 = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux1;
				
				//Troca de lugar os IDs de acordo com a prioridade trocada.
				int aux2 = ID[i];
				ID[i] = ID[j];
				ID[j] = aux2;
				
				descer(j);				
			}
		}
	}
	
	/**
	 * Constroe as duas listas passadas por parâmetro 
	 * atribuindo a característica de Heap Mínimo. 
	 */
	public void construir(int entrada[]){
		//Preenche o heap.
		for(int i = 0; i < entrada.length; i++){
			vetor[i] = entrada[i];
		}
		//Preenche o vetor de IDs.
		for(int k = 0; k < entrada.length; k++){
			ID[k] = entrada[k];
		}
		n = entrada.length;
		
		for(int j = n/2; j >= 0; j--){
			descer(j);
		}
	}
	
	public boolean isEmpty(){
		return (n == 0);
	}
	
	/*
	 * Os métodos abaixo PRECISAM de modificação.
	 */
	
	public int remove(){
		if(n > 0){
			int aux = vetor[0];
			vetor[0] = vetor[n - 1];
			ID[0] = ID[n - 1];
			n--;
			descer(0);
			return aux;
		}
		return 0;
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
				return;
			}
		}
	}	
	
	/*
	 * Os métodos abaixo NÃO PRECISAM de modificação.
	 */
	
	public int getMinimaPrioridade(){
		if(n > 0){
			return vetor[0];
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
	
	public void mostrarHeap(){
		System.out.println("Quantidade de elementos: " + n + ", e elem. do Heap Minimo:");
		
		for(int i = 0; i < n; i++){
			System.out.print(vetor[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void mostrarIDs(){
		System.out.println("Identificadores do Heap Mínimo:");
		
		for(int i = 0; i < n; i++){
			System.out.print(ID[i] + " ");
		}
		System.out.println("\n");
	}
}
