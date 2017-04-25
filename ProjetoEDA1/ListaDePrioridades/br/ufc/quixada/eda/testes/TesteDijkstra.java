package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.listaprioridades.LPMaximaOrdenada;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteDijkstra {
	
	public static void main(String[] args) {
		try {
			for(int tamanho : CriarInstancia.tamanhoInstancias){
				for(int i = 0; i < 4; i++){
					String path = EDAConstants.grafoDijkstra + "tb8ch" + tamanho + "_" + ".txt";
					
					Grafo entrada = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();
					Dijkstra grafo = new Dijkstra();
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i + ":");
					grafo.execucao(entrada);
				
					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println("Tempo: " + tempo + ".");
				}
			}
		}catch (IOException e) {
		e.printStackTrace();
		}
	}
}

