import java.util.Scanner;

public class BoardGameMain {
    static int qtdHouse;
    static int qtdPlayer;
    static int nowPlayer = 0;

    static int playNumber = 0;
    static final Player[] nPlayer = new Player[4];

    private static Player playerN(int i) {
        return switch (i) {
            case 1 -> nPlayer[0];
            case 2 -> nPlayer[1];
            case 3 -> nPlayer[2];
            case 4 -> nPlayer[3];
            default -> null;
        };
    }

    public static void main(String[] args) {
        BoardGame boardGame = new BoardGame();
        Player nextPlayer = boardGame.nextPlayer();

        Scanner sc = new Scanner(System.in);

        System.out.println("//==========================================================================//");
        System.out.println("//               JOGO DOS TABULEIROS                                        //");
        System.out.println("//==========================================================================//");
        System.out.println("\n//************ Informe a quantidade desejda de casas (minímo 10 casas) -> ");
        qtdHouse = sc.nextInt();

        System.out.println("//************* Informe a quantidade desejda de jogadores -> ");
        qtdPlayer = sc.nextInt();

        if (qtdHouse < 10) {
            System.out.println("O numero de casas deve ser maior que 10");
        }
        if (qtdPlayer <= 4 && qtdPlayer >= 2) {
            System.out.println("O numero de jogadores deve ser maior que 2 e menor q 4");
        }

        if (nextPlayer.getNumber() == 1) {
            playNumber++;
        }

        while (true) {
            System.out.println("==========================================================");
            System.out.println("     JOGO DE TABULEIRO COM " + qtdHouse);
            System.out.println("     Número de  jogadores: " + qtdPlayer);
            System.out.println("     Número da Jogada " + playNumber);
            System.out.println("==========================================================");
            boardGame.printElementsClockwise();
            System.out.println("********* Próximo a jogar -> " + nextPlayer.getName());
            System.out.println("==========================================================");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%% MENU %%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("===================== 1 - Iniciar o jogo =================");
            System.out.println("===================== 2 - Encerrar o jogo ================");
            int option = sc.nextInt();
            if (option == 1) {
                int dice = boardGame.rollDice();
                System.out.println(" *Dado sendo jogado* ");
                System.out.println("Número -> " + dice);
                while (true) {
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%% Escolha o sentido da jogada %%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println("===================== 1 - Sentido horario =====================");
                    System.out.println("===================== 2 - Sentido anti-horario ================");
                    int direction = sc.nextInt();
                    BoardHouse newHouse;
                    BoardHouse currentHouse = nextPlayer.getHouse();

                    if (currentHouse == null) {
                        currentHouse = boardGame.getInit();
                    } else {
                        dice++;
                    }

                    if (direction == 1) {
                        newHouse = boardGame.getPositionClockwise(dice, currentHouse);
                    } else {
                        newHouse = boardGame.getPositionCounterclockwise(dice, currentHouse);
                    }
                    nextPlayer.setHouse(newHouse);
                    nextPlayer.setLostTime(newHouse.getPenalty());
                    //Se a casa for vazia, coloca o jogador na casa
                    if (newHouse.getStatus() == 0) {
                        newHouse.setStatus(1);
                        newHouse.setPlayer(nextPlayer.getNumber());
                    }
                    //Se a casa for ocupada, remove o jogador da casa e a casa passa a ser livre
                    else if (newHouse.getStatus() == 1 || newHouse.getPlayer() != nextPlayer.getNumber()) {
                        newHouse.setPlayer(0);
                        newHouse.setStatus(0);
                    }
                    //Se a casa for ocupada pelo mesmo jogador ele passa a ser proprietário
                    else if (newHouse.getStatus() == 2 && newHouse.getPlayer() == nextPlayer.getNumber()) {
                        newHouse.setStatus(2);
                        newHouse.setPlayer(nextPlayer.getNumber());
                    }
                    BoardHouse prevHouse = newHouse.getPrev();

                    //= casa anterior e' do mesmo jogador? -> cria uma nova no meio
                    if (prevHouse.getStatus() == 2 && prevHouse.getPlayer() == nextPlayer.getNumber()) {
                        BoardHouse bonusHouse = new BoardHouse();
                        bonusHouse.setPlayer(nextPlayer.getNumber());
                        bonusHouse.setStatus(2);
                        boardGame.insertElementClockwise(bonusHouse, newHouse);
                    }

                    BoardHouse nextHouse = newHouse.getNext();

                    if (nextHouse.getStatus() == 2 && nextHouse.getPlayer() == nextPlayer.getNumber()) {
                        BoardHouse bonusHouse = new BoardHouse();
                        bonusHouse.setPlayer(nextPlayer.getNumber());
                        bonusHouse.setStatus(2);
                        boardGame.insertElementClockwise(newHouse, bonusHouse);
                    } else if (newHouse.getStatus() == 2 && newHouse.getPlayer() == nextPlayer.getNumber()) {
                        nextPlayer.setLostTime(nextPlayer.getLostTime() + 1);
                    }
                    break;

                }
            } else if (option == 2) {
                System.out.println("Deseja encerrar o jogo? (1 - NÃO / 2 - SIM)");
                int endGame = sc.nextInt();
                if (endGame == 2) {
                    System.out.println("Encerrando o jogo...");
                    break;
                }
            }

        }
    }
}

