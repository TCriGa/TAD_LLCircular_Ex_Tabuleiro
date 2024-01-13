import java.util.Scanner;

public class Main {
    static int qtdHouse;
    static int qtdPlayer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("//==========================================================================//");
        System.out.println("//               JOGO DOS TABULEIROS                                        //");
        System.out.println("//==========================================================================//");
        System.out.println("\n//************ Informe a quantidade desejda de casas (minímo 10 casas) -> ");
        qtdHouse = sc.nextInt();

        System.out.println("//************* Informe a quantidade desejda de jogadores -> ");
        qtdPlayer = sc.nextInt();

        if(qtdHouse < 10){
            System.out.println("O numero de casas deve ser maior que 10");
        }
        if( qtdPlayer <= 4 && qtdPlayer >= 2){
            System.out.println("O numero de jogadores deve ser maior que 2 e menor q 4");
    }

        System.out.println("==========================================================");
        System.out.println("     JOGO DE TABULEIRO COM " + qtdHouse );
        System.out.println("     Número de  jogadores: " + qtdPlayer);
        System.out.println("==========================================================");


    }}

