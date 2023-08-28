import java.util.Scanner;
public class Functions {
    static double[][] PreencherMatrixDePontos(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o numero de pontos: ");
        int numOfPoints = sc.nextInt();
        double[][] matrixOfPoints = new double[numOfPoints][numOfPoints];
        for(int column = 0; column<numOfPoints; column++){
            int line = 0;
            System.out.printf("insira o valor de X%d: ",column);
            matrixOfPoints[line][column] = sc.nextDouble();
            line++;
            System.out.printf("insira o valor de Y%d: ",column);
            matrixOfPoints[line][column] = sc.nextDouble();
        }
        sc.close();
        return matrixOfPoints;
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
    public static double method_Lagrange(double pontoInterpolador){
        double[][] matrixOfPoints = PreencherMatrixDePontos();
        int numOfPoints = matrixOfPoints[0].length;
        double resultInterpolacao = 0;
        for(int i =0; i < numOfPoints; i++){
            double coeficiente = matrixOfPoints[1][i];
            for(int j =0; j < matrixOfPoints[0].length; j++){
                if(i != j){
                    coeficiente *= (pontoInterpolador-matrixOfPoints[0][j])/(matrixOfPoints[0][i]-matrixOfPoints[0][j]);
                }
            }
            resultInterpolacao += coeficiente;
        }
        return resultInterpolacao;
    }

    static double[] MetodoIterativoGauss(){
       double[][] equacoes = CriarEPreencherMatrixValoresSistema();
       double[] vetorResultado = new double[equacoes.length];
        return vetorResultado;
    }

    public static double method_Interpolation_Polinomial(double valorInterpolar){
        double[][] matrixPontos = PreencherMatrixDePontos();
        double resultInterpolacao = 0;
        double[] xx = new double[matrixPontos[1].length];
        for(int i = 0;i < xx.length; i++ ){
            xx[i] = matrixPontos[1][i];
        }
        for (int i = 0; i < matrixPontos.length-1; i++) {
            for (int j = 0; j < matrixPontos.length-1-i; j++) {
                xx[j] = (valorInterpolar - matrixPontos[0][j]) / (matrixPontos[0][i + j + 1] - matrixPontos[0][j]) * xx[j + 1] + (valorInterpolar - matrixPontos[0][i + j + 1]) / (matrixPontos[0][j] - matrixPontos[0][i + j + 1]) * xx[j];
            }
            
        }
        resultInterpolacao = xx[0];
        return resultInterpolacao;
    }
}