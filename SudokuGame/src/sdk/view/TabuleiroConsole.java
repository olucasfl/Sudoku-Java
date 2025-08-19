package sdk.view;

import java.util.Scanner;
import sdk.model.Tabuleiro;

public class TabuleiroConsole {
    
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        boolean continuar = true;

        while (continuar) {
            cicloDoJogo();

            System.out.print("Outra partida? (S/n): ");
            String resposta = entrada.nextLine();

            if ("n".equalsIgnoreCase(resposta)) {
                continuar = false;
            } else {
                tabuleiro = new Tabuleiro();
            }
        }

        System.out.println("Tchau!!");
    }

    private void cicloDoJogo() {
        while (tabuleiro.estaVivo()) {
            tabuleiro.imprimirTabuleiro(tabuleiro.getSudoku());

            System.out.print("Digite (linha,coluna,valor) ou 'sair': ");
            String comando = entrada.nextLine();

            if ("sair".equalsIgnoreCase(comando)) {
                break;
            }

            try {
                String[] partes = comando.split(",");
                int linha = Integer.parseInt(partes[0].trim());
                int coluna = Integer.parseInt(partes[1].trim());
                int valor = Integer.parseInt(partes[2].trim());

                tabuleiro.jogar(linha, coluna, valor);

            } catch (Exception e) {
                System.out.println("Entrada inválida! Use formato: linha,coluna,valor");
            }
        }

        if (!tabuleiro.estaVivo()) {
            System.out.println("💀 Game Over! Você perdeu todas as vidas.");
        }
    }
}
