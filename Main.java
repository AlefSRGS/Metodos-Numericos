import java.util.Scanner;
public class Main {
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Metodo de Lagrange.");
        System.out.println("2 - Metodo de Gauss.");
        System.out.println("3 - Metodo Convencional Interpolação");
        System.out.println("0 - parar");
        System.out.print("Insira a opcao desejada: ");
        int optionMenu = sc.nextInt();
        if(optionMenu == 0){
            sc.close();
            return;
        }
        System.out.println();
        selectionOption(optionMenu);
    }
    static void selectionOption(int option){
        Scanner sc = new Scanner(System.in);
        if(option == 1){
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double FunctionInterpolar = Functions.method_Lagrange(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f\n",FunctionInterpolar);
        }
        if(option == 2){

        }
        if(option == 3){
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double functionInterpolar = Functions.method_Interpolation_Polinomial(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f\n",functionInterpolar);
        }
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}
