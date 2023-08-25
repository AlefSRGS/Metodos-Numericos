import java.util.Scanner;

public class Functions {
    static void PreencherMatrixDePontos(double[][] matrix){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o numero de pontos: ");
        int numOfPoints = sc.nextInt();
        double[][] matrixOfPoints = new double[numOfPoints][numOfPoints];
        for(int column = 0; column<numOfPoints; column++){
            int line = 0;
            System.out.printf("insira o valor de X%d: ",column);
            matrix[line][column] = sc.nextInt();
            line++;
            System.out.printf("insira o valor de Y%d: ",column);
            matrix[line][column] = sc.nextInt();
        }
        sc.close();
    }
    static double[][] CriarEPreencherMatrixValoresSistema(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ensira a grandeza do sistema: ");
        int grandezaSistema = sc.nextInt();
        System.out.println();
        //matriz cujas linhas sao os valores de cada equação sendo a ultima coluna o resultado delas
        double[][] matrixValores = new double[grandezaSistema][grandezaSistema+1];
        for(int column = 0; column < matrixValores[0].length; column++){
            //condicao para preencher o resultado dessas equacoes que se encontram na ultima coluna da matrix
            for(int line = 0; line < matrixValores.length; line++ ){
                if(column == matrixValores[0].length -1){
                    System.out.printf("Insira o resultado da equacao %d: ", line+1);
                    matrixValores[line][column] = sc.nextDouble();
                    break;
                }
                System.out.printf("insira o valor %d da equacao %d: ", column, line);
                matrixValores[line][column] = sc.nextDouble();
            }
        }
        sc.close();
        return matrixValores;
    }

    static double Method_Lagrange(double[][] matrixOfPoints, int numOfPoints, double pontoInterpolador){
        PreencherMatrixDePontos(matrixOfPoints, numOfPoints);
        double FunctionInterpolar = 0;
        for(int i =0; i < numOfPoints; i++){
            double L = 1;
            for(int j =0; j < numOfPoints; j++){
                L = L * (pontoInterpolador-matrixOfPoints[0][j])/(matrixOfPoints[0][i]-matrixOfPoints[0][j]);
            }
            FunctionInterpolar = FunctionInterpolar + matrixOfPoints[1][i] * L;
        }
        return FunctionInterpolar;
    }
    static double[] MetodoIterativoGauss(){
       double[][] equacoes = CriarEPreencherMatrixValoresSistema();
       double[] vetorResultado = new double[equacoes.length];
        return vetorResultado;
    }
}