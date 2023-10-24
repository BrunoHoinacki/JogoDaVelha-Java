package jogodavelha.players;

import jogodavelha.board.Tabuleiro;
import jogodavelha.exceptions.players.PlayerNotCreatedException; 

import java.util.Scanner;

public class Humano extends Jogador {

    public Scanner entrada = new Scanner(System.in);

    public Humano(int jogador) {
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        if (tabuleiro == null) {
            throw new PlayerNotCreatedException("O jogador 'Humano' não pode jogar, pois o tabuleiro não foi criado.");
        }

        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            try {
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();

                if (tentativa[0] > 3 || tentativa[0] < 1) {
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                    continue;
                }

                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();

                if (tentativa[1] > 3 || tentativa[1] < 1) {
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                    continue;
                }

                tentativa[0]--; 
                tentativa[1]--;

                if (!checaTentativa(tentativa, tabuleiro)) {
                    System.out.println("Esse local já foi marcado. Tente outro.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                entrada.next();  // Limpa o buffer do scanner
            }
        } while (!checaTentativa(tentativa, tabuleiro));
    }
}
