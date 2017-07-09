package rubroNegra;

public class ArvoreRubroNegra<Chave extends Comparable<Chave>, G> {

	    private static final boolean VERMELHO   = true;
	    private static final boolean PRETO = false;	
	    private NodeRubroNegra raiz;
	    
	    private class NodeRubroNegra {
	        public Chave chave;
	        public G info;
	        public NodeRubroNegra esq, dir, pai;
	        public boolean cor;

	        public NodeRubroNegra(Chave chave, G info, boolean cor) {
	            this.chave   = chave;
	            this.info = info;
	            this.cor = cor;
	        }
	    }
	    
	    
	    private boolean isPreto(NodeRubroNegra no) {
	         if (no == null) return true;
	         return (no.cor == PRETO);
	    }
	    
	    
	    public G busca(Chave chave){
	    	 if(chave == null) return null;
	    	 return busca(raiz, chave);
	    }
	       
	    
	    private G busca(NodeRubroNegra raiz, Chave chave){
	    	 if(raiz == null) return null;
	    	
	    	 int cmp = chave.compareTo(raiz.chave);
	    	 if(cmp < 0) return busca(raiz.esq, chave);
	    	 else if(cmp > 0) return busca(raiz.dir, chave);
	    	 else return raiz.info;
	    }    
	    
	 
	    private NodeRubroNegra noInserido = null;
	    public void inserir(Chave chave, G info){
	    	if(chave == null) throw new IllegalArgumentException("Chave deve ser diferente de null.");
	    	noInserido = null;
	    	raiz = inserir(raiz, chave, info);
	    	if(noInserido != null) reorganizarInsercao(noInserido);
	    	raiz.cor = PRETO;
	    	raiz.pai = null;
	    }
	    
	 
	    private NodeRubroNegra inserir(NodeRubroNegra raiz, Chave chave, G info){
	    	 if(raiz == null){
	    		 noInserido = new NodeRubroNegra(chave, info, VERMELHO);
	    		 return noInserido;
	    	 }
	    	 
	    	 int cmp = chave.compareTo(raiz.chave);	   	 
		   	 if(cmp < 0){
		   		 raiz.esq = inserir(raiz.esq, chave, info);
		   		 raiz.esq.pai = raiz;
		   	 }
		   	 else if(cmp > 0){
		   		 raiz.dir = inserir(raiz.dir, chave, info);
		   		 raiz.dir.pai = raiz;
		   	 }	         
		   	 return raiz;
	    }  
	    
	  
	    private void reorganizarInsercao(NodeRubroNegra z){
	    	
	    	while(!isPreto(z.pai)){
	    		if(z.pai == z.pai.pai.esq){//Caso onde o z descendente a esquerda de seu avó.
	    			NodeRubroNegra y = z.pai.pai.dir;//Tio do z. Posivelmente null.
	    			if(!isPreto(y)){
	    				
	    				z.pai.cor = PRETO;
	    				y.cor = PRETO;
	    				z.pai.pai.cor = VERMELHO;
	    				z = z.pai.pai;
	    			}else{
	    				if(z == z.pai.dir){//Caso 2
	    					/*
	    					 * Transforma para aplicar o caso 3.  
	    					 */
	    					z = z.pai;    					
	    	   				NodeRubroNegra pai = z.pai;
	        				if(pai.esq == z) pai.esq = rotacaoEsquerda(z);
	        				else pai.dir = rotacaoEsquerda(z);  
	    				}
	    				
	    				z.pai.cor = PRETO;
	    				z.pai.pai.cor = VERMELHO;
	    				
		   				NodeRubroNegra pai = z.pai.pai.pai;
		   				if(pai == null) raiz = rotacaoDireita(z.pai.pai);
		   				else if(pai.esq == z.pai.pai) pai.esq = rotacaoDireita(z.pai.pai);
	    				else pai.dir = rotacaoDireita(z.pai.pai);          				    				
	    			}    			
	    		}else{//Caso onde o z descendente a direita de seu avó.
	    			NodeRubroNegra y = z.pai.pai.esq;
	    			if(!isPreto(y)){//Caso 1
	    				z.pai.cor = PRETO;
	    				y.cor = PRETO;
	    				z.pai.pai.cor = VERMELHO;
	    				z = z.pai.pai;
	    			}else{//Caso 2
	    				if(z == z.pai.esq){
	    					z = z.pai;    					
	    	   				NodeRubroNegra pai = z.pai;
	        				if(pai.esq == z) pai.esq = rotacaoDireita(z);
	        				else pai.dir = rotacaoDireita(z);  
	    				}	
	    				//Caso 3
	    				z.pai.cor = PRETO;
	    				z.pai.pai.cor = VERMELHO;
	    				
		   				NodeRubroNegra pai = z.pai.pai.pai;
		   				if(pai == null) raiz = rotacaoEsquerda(z.pai.pai);
		   				else if(pai.esq == z.pai.pai) pai.esq = rotacaoEsquerda(z.pai.pai);
	    				else pai.dir = rotacaoEsquerda(z.pai.pai);          				
	    			}      			
	    		}
	    	}
	    }    
	    
	    
	    private NodeRubroNegra noExcluido = null;
	    public void remover(Chave chave){
	    	if(chave == null) throw new IllegalArgumentException("Chave deve ser diferente de null.");
	    	    	
	    	noExcluido = null;
	    	raiz = remover(raiz, chave, null);
	    	
	    	if(noExcluido != null) reorganizarRemocao(noExcluido);
	    	
	    	if(raiz != null) raiz.cor = PRETO;
	    }
	    
	 
	    private NodeRubroNegra remover(NodeRubroNegra raiz, Chave chave, NodeRubroNegra pai){
	   	 	 if(raiz == null) return null;
	 	
		   	 int cmp = chave.compareTo(raiz.chave);
		   	 
		   	 if(cmp < 0) raiz.esq = remover(raiz.esq, chave, raiz);
		   	 else if(cmp > 0) raiz.dir = remover(raiz.dir, chave, raiz);
		   	 else{
		   		 if(raiz.esq == null && raiz.dir == null){
		   			 if(!isPreto(raiz)) raiz = null;//Não tem nenhum filho e é vermelho, apenas remove a referência do no.
		   			 else{//Não tem nenhum filho e é preto, verifica os 4 casos "explicado" em sala :).
		   				noExcluido = raiz;
		   			 }
		   		 }
		   		 else if(raiz.esq == null || raiz.dir == null){//Apenas um filho, logo ele é preto, atualiza a nova raiz, em outra palavras, atualiza o pai indicando seu novo filho.	   			 
		   			 raiz = (raiz.esq == null ? raiz.dir : raiz.esq);
		   			 raiz.cor = PRETO;
		   		 }else{//Dois filhos, busca o sucessor e copia seu valor para esse nó e exclui o sucessor.
		   			 /*
		   			  * Busca pelo sucessor e copia os dados do sucessor para o nó a ser excluído.
		   			  */
		   			 NodeRubroNegra suces = sucessor(raiz.dir);
		   			 raiz.info = suces.info;
		   			 raiz.chave = suces.chave;
		   			 
		   			 /*
		   			  * Exclui na verdade, o sucessor.
		   			  */
		   			 if(suces.dir != null){//Caso em que o sucessor tem o filho direito
		   				 suces.pai.esq = suces.dir;
		   				 suces.dir.pai = suces.pai;
		   				 suces.dir.cor = PRETO;	
		   			 }else if(!isPreto(suces)) suces.pai.esq = null;//Caso em que o sucessor não tem filho e é vermelho.
		   			 else{
		   				noExcluido = suces;//Não tem nenhum filho e é preto, verifica os 4 casos "explicado" em sala :).
		   			 }
		   		 }
		   	 }
		   	 return raiz;    	
	    }  
	    private void reorganizarRemocao(NodeRubroNegra x){
	    	if(x.pai == null){
	    		raiz = null;
	    		return;
	    	}
	    	
	    	NodeRubroNegra noRemover = x;
	    	while(isPreto(x) && x != raiz){
	    		if(x == x.pai.esq){//Caso onde x é filho a esquerdo de seu pai.
	    			NodeRubroNegra w = x.pai.dir;//Irmão de x. Possilvemente null.
	    			if(!isPreto(w)){//Caso 1
	    				/*
	    				 * W é vermelho. 
	    				 * Altera a árvore apenas para aplicar um dos demais casos, ou seja, não torna a árvore rubro negra.
	    				 */
	    				w.cor = PRETO;
	    				x.pai.cor = VERMELHO;
	    				
	    				NodeRubroNegra avo = x.pai.pai;
	    				if(avo.esq == x.pai) avo.esq = rotacaoEsquerda(x.pai);
	    				else avo.dir = rotacaoEsquerda(x.pai);    				
	    				w = x.pai.dir;
	    			}
	    			
	    			if(w != null && isPreto(w.esq) && isPreto(w.dir)){//Caso 2
	    				/*
	    				 * W e seus filhos pretos.
	    				 * Torna w vermelho e atualiza o x.
	    				 */
	    				w.cor = VERMELHO;
	    				x = x.pai;
	    			}else{
	    				if(w != null  && isPreto(w.dir)){//Caso 3
	    					/*
	    					 * W e seu filho direito preto e esquerdo vermelho.
	    					 * Altera para aplicar o caso 4, ou seja, não torna a árvore rubro negra.
	    					 */
	    					if(w.esq != null) w.esq.cor = PRETO;
	    					w.cor = VERMELHO;
	    					x.pai.dir = rotacaoDireita(w);
	    					w = x.pai.dir;
	    				}
	    				//Caso 4
	    				/*
	    				 * W preto e seu filho direito vermelho.
	    				 * Após esse caso, ele voltou a ser rubro negra e sai da iteração.
	    				 */
						if(w != null) w.cor = w.pai.cor;
						if(w != null) w.pai.cor = PRETO;
						if(w != null && w.dir != null) w.dir.cor = PRETO;
						
	    				NodeRubroNegra avo = x.pai.pai;
	    				if(avo.esq == x.pai) avo.esq = rotacaoEsquerda(x.pai);
	    				else avo.dir = rotacaoEsquerda(x.pai);     					
	    				
	    				x = raiz;
	    			}
	    		}else{//Caso onde x é filho a direito de seu pai.
	    			NodeRubroNegra w = x.pai.esq;
	    			if(!isPreto(w)){//Caso 1
	    				w.cor = PRETO;
	    				x.pai.cor = VERMELHO;
	    				NodeRubroNegra avo = x.pai.pai;
	    				if(avo.esq == x.pai) avo.esq = rotacaoDireita(x.pai);
	    				else avo.dir = rotacaoDireita(x.pai);    				
	    				w = x.pai.esq;
	    			}
	    			
	    			if(w != null && isPreto(w.esq) && isPreto(w.dir)){//Caso 2
	    				w.cor = VERMELHO;
	    				x = x.pai;
	    			}else{
	    				if(w != null && isPreto(w.esq)){//Caso 3
	    					if(w.esq != null) w.esq.cor = PRETO;
	    					w.cor = VERMELHO;
	    					x.pai.dir = rotacaoEsquerda(w);
	    					w = x.pai.esq;
	    				}
	    				
	    				//Caso 4
						if(w != null && w.pai != null) w.cor = w.pai.cor;
						if(w != null && w.pai != null)w.pai.cor = PRETO;
						if(w != null && w.esq != null) w.esq.cor = PRETO;
						
	    				NodeRubroNegra avo = x.pai.pai;
	    				if(avo != null && avo.esq == x.pai) avo.esq = rotacaoDireita(x.pai);
	    				else if(avo != null) avo.dir = rotacaoDireita(x.pai);     					
	    				
	    				x = raiz;
	    			}    			
	    		}
	    	}
	    	if(noRemover == noRemover.pai.esq) noRemover.pai.esq = null;
	    	else noRemover.pai.dir = null;    	
	    }
	    
	    private NodeRubroNegra sucessor(NodeRubroNegra raiz){   	
	    	if(raiz.esq != null) return sucessor(raiz.esq);
	    	else return raiz; 
	    }    
	    
	    private NodeRubroNegra rotacaoDireita(NodeRubroNegra no) {
	        NodeRubroNegra x = no.esq;
	        if(x != null) no.esq = x.dir;
	        if(x != null) x.dir = no;
	   	 
	        if(x != null)x.pai = no.pai;
	        no.pai = x;
	        if(no.esq != null) no.esq.pai = no;        
	        return x;
	    }

	    private NodeRubroNegra rotacaoEsquerda(NodeRubroNegra no) {
	        NodeRubroNegra x = no.dir;
	        if(x != null) no.dir = x.esq;
	        if(x != null) x.esq = no;
	   	 	
	        if(no != null && x != null) x.pai = no.pai;
	        no.pai = x;
	        if(no.dir != null) no.dir.pai = no;
	        return x;
	    }    
}
