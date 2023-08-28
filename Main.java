import java.util.Scanner;
public class Main {
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Metodo de Lagrange.");
        System.out.println("2 - Metodo de Gauss.");
        System.out.print("Insira a opcao desejada: ");
        int optionMenu = sc.nextInt();
        System.out.println();
        selectionOption(optionMenu);
        sc.close();
    }
    static void selectionOption(int option){
        Scanner sc = new Scanner(System.in);
        if(option == 1){
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double FunctionInterpolar = Functions.method_Lagrange(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f",FunctionInterpolar);
        }
        sc.close();
    }
    public static void main(String[] args) {
        menu();
    }
}
