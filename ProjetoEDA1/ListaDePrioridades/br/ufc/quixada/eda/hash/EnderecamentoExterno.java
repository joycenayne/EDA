package br.ufc.quixada.eda.hash;

import java.util.LinkedList;
import java.util.List;

public class EnderecamentoExterno extends Hash {

private List[] tabela = null;

	
	public EnderecamentoExterno(Integer tam) {
		super(tam);
		 tabela = new LinkedList[this.m + 1];
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Integer chave, String valor) {
		Integer n = fHash(chave);

		NoHash no = new NoHash (chave, valor);
		if(tabela[n] == null){
			tabela[n] = new LinkedList<>();
		}
		tabela[n].add(no);
	}


	@Override
	public String buscar(Integer chave) {
		Integer n = fHash(chave);
		if(tabela[n] == null) return null;
		for(NoHash x : tabela[n]){
			if(x.getChave() == chave){
				return x.getValor();
			}
		}
		return null;
	}

	@Override
	public String remover(Integer chave) {
		Integer n = fHash(chave);
		if(tabela[n] == null) return null;
		for(NoHash x : tabela[n]){
			if(x.getChave() == chave){
				tabela[n].remove(x);
				return x.getValor();
			}
		}
		return null;
	}

}
