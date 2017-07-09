package testesComp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import aVL.ArvoreAVL;

public class MainAVL {
	public static void main(String[] args) {
		try{		
			String path = System.getProperty("user.dir") + "/Instancias/ProjetoFinal/" + "empresasC.txt";
			ArrayList<Empresa> entrada = TesteUtil.getDadosIniciais(path);
			ArvoreAVL<String, Empresa> arvAVL = new ArvoreAVL<>();
			
			//Inserção dos dados
			long tempoInicial = System.currentTimeMillis();
			for(Empresa empresa : entrada){
				arvAVL.inserir(empresa.getNome(), empresa);
			}
			long tempoFinal = System.currentTimeMillis();
				
			int tempo = (int) (tempoFinal - tempoInicial);
			System.out.println("O tempo de inserção dos dados é de " + tempo + " milissegundos.");
				
			Collections.shuffle(entrada);
			
			//Busca dos 30% das instancias
			tempoInicial = System.currentTimeMillis();
			for(int i = 4000; i < 7000; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}
			tempo = (int) (System.currentTimeMillis() - tempoInicial);
			System.out.println("Tempo para Buscar aleatoriamente 30% das instâncias: " + tempo + " milissegundos");
					
			// Remove 30%  das instâncias
			tempoInicial = System.currentTimeMillis();
			for(int i = 7000; i < 10000; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
			tempo = (int) (System.currentTimeMillis() - tempoInicial);
			System.out.println("Tempo para Remover aleatoriamente 30% das instâncias: " + tempo + " milissegundos");
					
			// As Três Operações Conjuntamente 			
			tempoInicial = System.currentTimeMillis();
			ArvoreAVL<String, Empresa> arvAVL2 = new ArvoreAVL<>();
			for(int i = 0; i < 1999; i++){
				arvAVL2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
				
			// Faz a Busca de 30% (600) das instancias  
			for(int i = 1000; i < 1600; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 200; i < 400; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
				
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 2000; i < 3999; i++){
				arvAVL2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
				
			// Faz a Busca de 30% (600) das instancias  
			for(int i = 2000; i < 2600; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 400; i < 600; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
				
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 3000; i < 4999; i++){
				arvAVL2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
				
			// Faz a Busca de 30% (600) das instancias 
			for(int i = 3000; i < 3600; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 600; i < 800; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
				
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 4000; i < 5999; i++){
				arvAVL2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
				
			// Faz a Busca de 30% (600) das instancias 
			for(int i = 4000; i < 4600; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 1000; i < 1200; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 5000; i < 6999; i++){
				arvAVL2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
				
			// Faz a Busca de 30% (600) das instancias 
			for(int i = 5000 ; i < 5600; i++){
				arvAVL.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 8500; i < 8700; i++){
				arvAVL.remover(entrada.get(i).getNome());
			}
				
			tempo = (int) (System.currentTimeMillis() - tempoInicial);
			System.out.println("Tempo para Operações Conjuntas: " + tempo + " milissegundos");
				
				
		}
		catch (Exception e) {
			// TODO: handle exception
           	e.printStackTrace();
      	}
			
	}
}