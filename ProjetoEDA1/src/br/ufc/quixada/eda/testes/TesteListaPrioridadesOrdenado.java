package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.listaprioridades.LPMaximaOrdenada;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesOrdenado {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//Para arquivo com maior quantidade de INSERÇÃO
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				LPMaximaOrdenada listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//Para arquivo com maior quantidade de ALTERAÇÃO
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
				//Para arquivo com maior quantidade de REMOÇÃO.
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("R")){
						listaPrioridade.remove();
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);	
				
				//Para arquivo com maior quantidade de SELEÇÃO.
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.construir(entrada);							
			
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("S")){
						listaPrioridade.getMaximaPrioridade();
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
