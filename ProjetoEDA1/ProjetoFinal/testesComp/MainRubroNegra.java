package testesComp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import rubroNegra.ArvoreRubroNegra;

public class MainRubroNegra {
	public static void main(String[] args) {
		try{
			
			String path = System.getProperty("user.dir") + "/Instancias/ProjetoFinal/" + "empresasC.txt";
			ArrayList<Empresa> entrada = TesteUtil.getDadosIniciais(path);
			ArvoreRubroNegra<String, Empresa> rubroNegra = new ArvoreRubroNegra<>();
		
			//Inserção dos dados 
			long tempoInicial = System.currentTimeMillis();
			for(int i = 0; i < entrada.size(); i++){
				rubroNegra.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			long tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo de inserção dos dados é de: " + tempo + " milissegundos");
			
			Collections.shuffle(entrada);
			
			// Busca dos 30% das instancias
			tempoInicial = System.currentTimeMillis();
			for(int i = 3000; i < 6000; i++){
				rubroNegra.busca(entrada.get(i).getNome());
			}
			
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Busca aleatória dos 30% é de: " + tempo + " milissengundos");
			
			//Remoção dos 30% das instancias
			tempoInicial = System.currentTimeMillis();
			for(int i = 6000; i < 9000; i++){
				rubroNegra.remover(entrada.get(i).getNome());
			}
			
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Remover aleatoriamente 30% das instâncias é de: " + tempo + " milissengundos");
			
			
			// As Três Operações Conjuntamente 			
			
			tempoInicial = System.currentTimeMillis();
			ArvoreRubroNegra<String, Empresa> rubroNegra2 = new ArvoreRubroNegra<>();
						
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 0; i < 1999; i++){
				rubroNegra2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
						
			// Faz a Busca de 30% (600) das instancias
			for(int i = 1000; i < 1600; i++){
				rubroNegra2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 100; i < 300; i++){
				rubroNegra2.remover(entrada.get(i).getNome());
			}
						
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 2000; i < 3999; i++){
				rubroNegra2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
						
			// Faz a Busca de 30% (600) das instancias
			for(int i = 400; i < 1600; i++){
				rubroNegra2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 400; i < 800; i++){
				rubroNegra2.remover(entrada.get(i).getNome());
			}
						
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 4000; i < 5999; i++){
				rubroNegra2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
						
			// Faz a Busca de 30% (600) das instancias
			for(int i = 900; i < 2700; i++){
				rubroNegra2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 900; i < 1500; i++){
				rubroNegra2.remover(entrada.get(i).getNome());
			}
						
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 6000; i < 7999; i++){
				rubroNegra2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
						
			// Faz a Busca de 30% (600) das instancias
			for(int i = 1600; i < 4000; i++){
				rubroNegra2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 1600; i < 2400; i++){
				rubroNegra2.remover(entrada.get(i).getNome());
			}
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 8000; i < 9999; i++){
				rubroNegra2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
						
			// Faz a Busca de 30% (600) das instancias
			for(int i = 2500; i < 5500; i++){
				rubroNegra2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 2600; i < 3600; i++){
				rubroNegra2.remover(entrada.get(i).getNome());
			}
						
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Operações Conjuntas: " + tempo + " milissegundos");
		
		}catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}
