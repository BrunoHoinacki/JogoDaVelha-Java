# Jogo da Velha em Java

Este é um simples jogo da velha em Java, implementado em um console interativo. Ele permite que dois jogadores joguem o clássico jogo da velha e determina o vencedor ou empate.

## Funcionalidades

- O jogo suporta dois jogadores humanos ou um jogador humano contra um computador.
- O tabuleiro é exibido no console.
- As jogadas são feitas alternadamente pelos jogadores.
- O jogo detecta e declara o vencedor ou empate.

## Estrutura do Projeto

O projeto é dividido em várias classes:

- `Jogo`: Esta classe controla a lógica principal do jogo.
- `Tabuleiro`: Esta classe gerencia o estado do tabuleiro do jogo.
- `Humano` e `Computador`: Estas classes representam os jogadores.
- `GameAlreadyOverException`, `GameNotStartedYetException`, `InputValidationException`, `PlayerNotCreatedException`, e `InvalidPositionException`: São exceções personalizadas usadas para lidar com erros específicos do jogo.

## Uso

1. Clone o repositório para o seu ambiente local.
2. Compile o código Java usando um compilador Java (por exemplo, `javac`).
3. Execute a classe `JogoDaVelha` para iniciar o jogo.

```bash
java JogoDaVelha


##Autor
Este jogo da velha em Java foi desenvolvido por Bruno Hoinacki.
