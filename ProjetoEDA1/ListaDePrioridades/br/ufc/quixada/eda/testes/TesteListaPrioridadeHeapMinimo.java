package br.ufc.quixada.eda.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class TesteListaPrioridadeHeapMinimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapMinimo heapMin = new HeapMinimo(50);
		int lista[] = new int[50];
		List<Integer> IDs = new ArrayList<>();
		
		
		Random numAleatorios = new Random(19700621);
		
		for(int i = 1; i <= 10; i++){
			lista[i] = (numAleatorios.nextInt(51));
		}
		for(int j = 1; j <= 10; j++){
			IDs.add(j);
		}
		
		
		heapMin.construir(lista);
		heapMin.mostrarHeap();
		heapMin.mostrarIDs();
		
		System.out.println("Valor de mínima prioridade: " + heapMin.getMinimaPrioridade() + ".\n");
		
		int valorRemovido1 = heapMin.remove();
		System.out.println("Valor removido: " + valorRemovido1 + ".\n");
		
		heapMin.mostrarHeap();
		heapMin.mostrarIDs();
		
		heapMin.inserir(1);
		heapMin.inserir(50);
		heapMin.mostrarHeap();
		heapMin.mostrarIDs();
		
		System.out.println("Valor de mínima prioridade: " + heapMin.getMinimaPrioridade() + ".\n");
		
		heapMin.alterarPrioridade(14, 56);
		heapMin.mostrarHeap();
		heapMin.mostrarIDs();
		System.out.println("Valor de mínima prioridade: " + heapMin.getMinimaPrioridade() + ".\n");
	

		int valorRemovido2 = heapMin.remove();
		System.out.println("Valor removido: " + valorRemovido2 + ".\n");
		
		heapMin.mostrarHeap();
		heapMin.mostrarIDs();
	}

}
