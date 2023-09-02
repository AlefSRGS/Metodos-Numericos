import java.util.Scanner;
public class Main {
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Metodo de Lagrange.");
        System.out.println("2 - Metodo Convencional Interpolação");
        System.out.println("3 - Metodo de Gauss");
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
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double functionInterpolar = Functions.method_Interpolation_Polinomial(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f\n",functionInterpolar);
        }
        if(option == 3){
            System.out.println("Qual o numero de interações maxima: ");
            int interactionMax = sc.nextInt();
            System.out.print("Ensira a grandeza do sistema: ");
            int grandezaSistema = sc.nextInt();
            double[] vetorResultado = new double[grandezaSistema];
            double[][] equacoes = new double[grandezaSistema][grandezaSistema]; 
            double[] termosIndependentes = new double[grandezaSistema];
            Functions.preencherMatrixValoresSistema(equacoes, termosIndependentes);
            System.out.println(Functions.MetodoIterativoGaussJacobi(interactionMax, grandezaSistema));
        }
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}
