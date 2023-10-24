package jogodavelha.game;

import jogodavelha.board.Tabuleiro;
import jogodavelha.exceptions.game.GameNotStartedYetException;
import jogodavelha.exceptions.game.GameAlreadyOverException;
import jogodavelha.exceptions.input.InputValidationException;
import jogodavelha.players.Computador;
import jogodavelha.players.Humano;
import jogodavelha.players.Jogador;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    private boolean gameAlreadyOver = false;
    private boolean gameStarted = false;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        gameStarted = true; 

        while (!gameAlreadyOver && Jogar());
    }

    public void iniciarJogadores() {
        System.out.println("Quem vai ser o Jogador 1 ?");
        if (escolherJogador() == 1)
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);

        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");

        if (escolherJogador() == 1)
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);
    }

    public int escolherJogador() {
        int opcao = 0;

        do {
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            if (opcao != 1 && opcao != 2)
                throw new InputValidationException("Opção inválida! Tente novamente");  // Lança InputValidationException
        } while (opcao != 1 && opcao != 2);

        return opcao;
    }

    public boolean Jogar() {
        if (!gameStarted) {
            throw new GameNotStartedYetException("O jogo ainda não começou.");
        }

        if (gameAlreadyOver || ganhou() != 0) {
            gameAlreadyOver = true;
            return false;
        }

        System.out.println("----------------------");
        System.out.println("\nRodada " + rodada);
        System.out.println("É a vez do jogador " + vez());

        if (vez() == 1)
            jogador1.jogar(tabuleiro);
        else
            jogador2.jogar(tabuleiro);

        if (tabuleiro.tabuleiroCompleto()) {
            System.out.println("Tabuleiro Completo. Jogo empatado");
            gameAlreadyOver = true;
            return false;
        }
        vez++;
        rodada++;

        return true;
    }

    public int vez() {
        if (vez % 2 == 1)
            return 1;
        else
            return 2;
    }

    public int ganhou() {
        if (tabuleiro.checaLinhas() == 1)
            return 1;
        if (tabuleiro.checaColunas() == 1)
            return 1;
        if (tabuleiro.checaDiagonais() == 1)
            return 1;

        if (tabuleiro.checaLinhas() == -1)
            return -1;
        if (tabuleiro.checaColunas() == -1)
            return -1;
        if (tabuleiro.checaDiagonais() == -1)
            return -1;

        return 0;
    }
}
