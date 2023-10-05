import java.util.Scanner;
public class Main {
    static void printVetor(double[] vetor){
        for (double d : vetor) {
            System.out.println(d);
        }
    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Metodo de Lagrange.");
        System.out.println("2 - Metodo Convencional Interpolação");
        System.out.println("3 - Metodo de Gauss");
        System.out.println("4 - Metodo dos Trapezios");
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
        if(option == 1){ //Metodo de Lagrange
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double FunctionInterpolar = Functions.method_Lagrange(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f\n",FunctionInterpolar);
        }
        if(option == 2){ //Metodo Convencional Interpolação
            System.out.print("Digite o ponto interpolador: ");
            double pontoInterpolador = sc.nextDouble();
            double functionInterpolar = Functions.method_Interpolation_Polinomial(pontoInterpolador);
            System.out.printf("A funcao interpolar resultante é: %f\n",functionInterpolar);
        }
        if(option == 3){ //Metodo de Gauss
            System.out.println("Qual o numero de interações maxima: ");
            int interactionMax = sc.nextInt();
            System.out.print("Ensira a grandeza do sistema: ");
            int grandezaSistema = sc.nextInt();
            double[] vetorResultado = new double[grandezaSistema];
            double[][] equacoes = new double[grandezaSistema][grandezaSistema]; 
            double[] termosIndependentes = new double[grandezaSistema];
            Functions.preencherMatrixValoresSistema(equacoes, termosIndependentes);
            vetorResultado = Functions.metodoIterativoGaussJacobi(grandezaSistema, equacoes, termosIndependentes, interactionMax, 0.001);
            if(vetorResultado == null){
                System.out.println("Sistema não convergiu dentro dos parametros desejados.");
            }else{
                printVetor(vetorResultado);
            }
        }if(option == 4){ //Metodo dos trapezios
            System.out.println("Insira o número de subintervalos: ");
            int subRangeNumber = sc.nextInt();
            System.out.println("Insira o limite inferior: ");
            int inferiorLimit = sc.nextInt();
            System.out.println("Insira o limite superior: ");
            int upperLimit = sc.nextInt();

            System.out.print("Integral aproximada com o metodo dos trapesios: ");
            System.out.println(Functions.trapesian_Method(subRangeNumber, inferiorLimit, upperLimit));
            System.out.print("Erro estimado: ");
            System.out.println(Functions.trapesian_Method_Estimated_Error(subRangeNumber, inferiorLimit, upperLimit));
        }
        
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}
