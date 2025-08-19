package sdk.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Tabuleiro {
	
	private Celula[][] tabuleiroEspelho = new Celula[9][9];
	private Celula[][] tabuleiro = new Celula[9][9];
	private int vidas = 3; // vidas do jogador
	
	public Tabuleiro() {
		preencherSudokuEspelho(0, 0);
		sudokuBase();
	}
	
	public boolean preencherSudokuEspelho(int linha, int coluna) {
        if (linha == 9) return true;
        if (coluna == 9) return preencherSudokuEspelho(linha + 1, 0);

        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 9; i++) numeros.add(i);
        Collections.shuffle(numeros);

        for (int numero : numeros) {
            if (isValido(linha, coluna, numero)) {
                tabuleiroEspelho[linha][coluna] = new Celula(linha, coluna, numero, Math.random() < 0.4);

                if (preencherSudokuEspelho(linha, coluna + 1)) return true;

                tabuleiroEspelho[linha][coluna] = null;
            }
        }

        return false;
    }
	
	public void sudokuBase() {
		for(int l = 0; l < 9; l++) {
			for(int c = 0; c < 9; c++) {
				if(tabuleiroEspelho[l][c].isFixa()) {
					tabuleiro[l][c] = tabuleiroEspelho[l][c];
				}
			}
		}	
	}
	
	public boolean isValido(int linha, int coluna, int numero) {
		for(int i = 0; i < 9; i++) {
			if(tabuleiroEspelho[i][coluna] != null && tabuleiroEspelho[i][coluna].getValor() == numero) return false;
			if(tabuleiroEspelho[linha][i] != null && tabuleiroEspelho[linha][i].getValor() == numero) return false;
		}
		
		int startLinha = (linha / 3) * 3;
		int startColuna = (coluna / 3) * 3;
		
		for(int l = startLinha; l < startLinha + 3; l++) {
			for(int c = startColuna; c < startColuna + 3; c++) {
				if(tabuleiroEspelho[l][c] != null && tabuleiroEspelho[l][c].getValor() == numero) return false;
			}
		}
		
		return true;
	}

	public boolean jogar(int linha, int coluna, int valor) {
	    Celula celula = tabuleiro[linha][coluna];
	    
	    if (celula != null && celula.isFixa()) {
	        System.out.println("❌ Não pode alterar uma célula fixa!");
	        return false;
	    }

	    if (tabuleiroEspelho[linha][coluna].getValor() == valor) {
	        tabuleiro[linha][coluna] = new Celula(linha, coluna, valor, false);
	        return true;
	    } else {
	        vidas--;
	        System.out.println("❌ Valor incorreto! Você perdeu uma vida.");
	        return false;
	    }
	}
	
	private static final char[] SUPER_NUM = {'0','1','2','3','4','5','6','7','8','9'};
	
	public void imprimirTabuleiro(Celula[][] tab) {
	    System.out.print("  ");
	    for (int c = 0; c < 9; c++) {
	    	if(SUPER_NUM[c] == '3' || SUPER_NUM[c] == '6') {
	    		System.out.print(" ");
	    	}
	        System.out.print(SUPER_NUM[c] + " ");
	        if (c % 3 == 2 && c != 8) System.out.print(" ");
	    }
	    System.out.println();

	    for (int l = 0; l < 9; l++) {
	        System.out.print(SUPER_NUM[l] + " "); 

	        for (int c = 0; c < 9; c++) {
	            if (tab[l][c] != null && tab[l][c].getValor() != 0) {
	                System.out.print(tab[l][c].getValor() + " ");
	            } else {
	                System.out.print(". ");
	            }

	            if (c % 3 == 2 && c != 8) System.out.print("| ");
	        }
	        System.out.println();

	        if (l % 3 == 2 && l != 8) System.out.println("  ------+-------+------"); 
	    }

	    System.out.println("\n❤ Vidas restantes: " + vidas);
	}
	
	public Celula[][] getTabuleiroEspelho() {
	    return tabuleiroEspelho;
	}
	
	public Celula[][] getSudoku() {
		return tabuleiro;
	}

	public int getVidas() {
		return vidas;
	}

	public boolean estaVivo() {
		return vidas > 0;
	}
}
