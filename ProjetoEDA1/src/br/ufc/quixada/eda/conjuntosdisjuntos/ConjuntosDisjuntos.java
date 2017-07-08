package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjuntosDisjuntos {
	
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	
	public ConjuntosDisjuntos(int n){
		this.n = n;
		pai = new int[n + 1];
		ordem = new int[n + 1];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	
	public void make_set_all(){
		for(int  i = 0; i < n; i++){
			make_set(i);
		}
	}
	
	public int find_set(int v){
		if(v == pai[v])
			return v;
		
		return find_set(pai[v]);
	}
	
	public int find_set_fast(int v){
		if(v == pai[v]){
			return v;
		}else{
			int paiV= find_set_fast(pai[v]);
			pai[v] = paiV;
			return paiV;
		}
	}
	
	public void link_set(int u, int v){
		pai[v] = u;
		
	}
	
	public void link_set_fast(int u, int v){
		if(ordem[v] < ordem[u]){
			pai[v] = u;
		}else{
			pai[u] = v;
			if(ordem[v] == ordem[u])
				ordem[v]++;
		}
	}
	
	public void union(int v, int u){
		link_set(find_set(v), find_set(u));
	}
	
}
