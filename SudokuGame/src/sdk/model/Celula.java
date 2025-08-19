package sdk.model;

public class Celula {

	private final int linha;
	private final int coluna;
	private final boolean fixa;
	private int valor = 0;
	
	public Celula(int linha, int coluna, int valor, boolean fixa) {
		this.linha = linha;
		this.coluna = coluna;
		this.valor = valor;
		this.fixa = fixa;
	}
	
	public String toString() {
	    if (valor == 0) {
	        return ". ";
	    } else {
	        return valor + " ";
	    }
	}

	
	public boolean isFixa() {
		return fixa;
	}
	
	public boolean isVazia() {
		return valor == 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if(!fixa) {
			this.valor = valor;			
		}
	}
}






