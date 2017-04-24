package br.ufc.quixada.eda.grafo;

public class Aresta {
	private int u;
	private int v;
	private int custo;
	
	public Aresta(int u, int v, int custo){
		this.u = u;
		this.v = v;
		this.custo = custo;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	
}
