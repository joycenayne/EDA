package testesComp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import splay.ArvoreSplay;

public class MainSplay {
	public static void main(String[] args) {
		try{
			
			String path = System.getProperty("user.dir") + "/Instancias/ProjetoFinal/" + "empresasC.txt";
			ArrayList<Empresa> entrada = TesteUtil.getDadosIniciais(path);
			ArvoreSplay<String, Empresa> splay = new ArvoreSplay<>();
			
			
			//Inserção dos dados
			long tempoInicial = System.currentTimeMillis();
			for(int i = 0; i < entrada.size(); i++){
				splay.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			long tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo de inserção dos dados é de: " + tempo + " milissegundos");
			
			
			Collections.shuffle(entrada);
			
			
			//Busca dos 30% das instancias
			tempoInicial = System.currentTimeMillis();
			for(int i = 4000; i < 7000; i++){
				splay.busca(entrada.get(i).getNome());
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Buscar aleatoriamente 30% das instâncias: " + tempo + " milissegundos");
			
			
			// Remove 30% das instâncias
			tempoInicial = System.currentTimeMillis();
			for(int i = 7000; i < 10000; i++){
				splay.remover(entrada.get(i).getNome());
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Remover aleatoriamente 30% das instâncias: " + tempo + " milissegundos");
			
			
			// As Três Operações Conjuntamente 			
			tempoInicial = System.currentTimeMillis();
			ArvoreSplay<String, Empresa> splay2 = new ArvoreSplay<>();
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 0; i < 1999; i++){
				splay2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			// Faz a Busca de 30% (600) das instancias
			for(int i = 1000; i < 1600; i++){
				splay2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 100; i < 300; i++){
				splay2.remover(entrada.get(i).getNome());
			}
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 2000; i < 3999; i++){
				splay2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			// Faz a Busca de 30% (600) das instancias
			for(int i = 400; i < 1600; i++){
				splay2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 400; i < 800; i++){
				splay2.remover(entrada.get(i).getNome());
			}
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 4000; i < 5999; i++){
				splay2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			// Faz a Busca de 30% (600) das instancias
			for(int i = 900; i < 2700; i++){
				splay2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 900; i < 1500; i++){
				splay2.remover(entrada.get(i).getNome());
			}
			
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 6000; i < 7999; i++){
				splay2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			// Faz a Busca de 30% (600) das instancias
			for(int i = 1600; i < 4000; i++){
				splay2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 1600; i < 2400; i++){
				splay2.remover(entrada.get(i).getNome());
			}
			// Faz a Inseção  20 % (1999) das instancias
			for(int i = 8000; i < 9999; i++){
				splay2.inserir(entrada.get(i).getNome(), entrada.get(i));
			}
			
			// Faz a Busca de 30% (600) das instancias
			for(int i = 2500; i < 5500; i++){
				splay2.busca(entrada.get(i).getNome());
			}

			//Faz a Remoção de 30% (200) das instancias
			for(int i = 2600; i < 3600; i++){
				splay2.remover(entrada.get(i).getNome());
			}
			
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para Operações Conjuntas: " + tempo + " milissegundos");
			
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
