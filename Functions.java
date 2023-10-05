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

    public static void preencherMatrixValoresSistema(double[][] matrixValores, double[] termosIndependente){
        Scanner sc = new Scanner(System.in);
        for(int line = 0; line < matrixValores.length; line++){
            for(int column = 0; column < matrixValores[0].length; column++ ){
                System.out.printf("insira o valor %d da equacao %d: ", column+1, line+1);
                matrixValores[line][column] = sc.nextDouble();
            }
            System.out.printf("Insira o valor da solução da equação %d: ", line+1);
            termosIndependente[line] = sc.nextDouble();
        }
        sc.close();
    }
    
    static double[] metodoIterativoGaussJacobi(int grandezaSistema, double[][] matrixCoeficientes, double[] termosIndependentes, int iteractionMax, double tolerancia){
        Scanner sc = new Scanner(System.in);
        double[] vetorResultado = new double[grandezaSistema];
        double[] vetorResultadoAnterior = new double[grandezaSistema];
        for (int iteration = 0; iteration < iteractionMax; iteration++) {
            //copiar o conteudo do vetor resultado para o vetor resultado anterior
            System.arraycopy(vetorResultado, 0, vetorResultadoAnterior, 0, grandezaSistema);

            for (int i = 0; i < grandezaSistema; i++) {
                double somaResultIntegral = 0;
                for (int j = 0; j < grandezaSistema; j++) {
                    if(j != i){
                        somaResultIntegral += matrixCoeficientes[i][j] * vetorResultadoAnterior[j];
                    }
                }
                vetorResultado[i] = (termosIndependentes[i]-somaResultIntegral) / matrixCoeficientes[i][i];
            }

            //teste tolerancia para convergencia
            double NormaNum = 0;
            double NormaDen = 0;
            for (int i = 0; i < grandezaSistema; i++) {
                double diferenca = Math.abs(vetorResultado[i] - vetorResultadoAnterior[i]);
                if (diferenca > NormaNum) {
                    NormaNum = diferenca;
                }
                if(Math.abs(vetorResultado[i]) > NormaDen){
                    NormaDen = Math.abs(vetorResultado[i]);
                }
            }
            double normaRel = NormaNum/NormaDen;
            if(normaRel <= tolerancia){
                //convergencia dentro da tolerancia
                return vetorResultado;
            }
        }
        //nao conseguiu convergir dentro da iteração limite
        return null;
    }

    public static double method_Interpolation_Polinomial(double valorInterpolar){
        double[][] matrixPontos = PreencherMatrixDePontos();
        double resultInterpolacao = 0;
        double[] coeficientes = new double[matrixPontos[1].length];
        for(int i = 0;i < coeficientes.length; i++ ){
            coeficientes[i] = matrixPontos[1][i];
        }
        for (int i = 0; i < matrixPontos.length-1; i++) {
            for (int j = 0; j < matrixPontos.length-1-i; j++) {
                coeficientes[j] = (valorInterpolar - matrixPontos[0][j]) / (matrixPontos[0][i + j + 1] - matrixPontos[0][j]) * coeficientes[j + 1] + (valorInterpolar - matrixPontos[0][i + j + 1]) / (matrixPontos[0][j] - matrixPontos[0][i + j + 1]) * coeficientes[j];
            }

        }
        resultInterpolacao = coeficientes[0];
        return resultInterpolacao;
    }

    public static double trapesian_Method(int subRangeNumber, double inferiorLimit, double upperLimit){

        // Calculando a largura do subintervalo
        double subRangeWidth = (upperLimit - inferiorLimit) / subRangeNumber;

        // Definindo os pontos x e calculando os correspondentes y = e^x
        double[] pointsX = new double[subRangeNumber + 1];
        double[] pointsY = new double[subRangeNumber + 1];
        for (int i = 0; i <= subRangeNumber; i++) {
            pointsX[i] = inferiorLimit + i * subRangeWidth;
            pointsY[i] = Math.exp(pointsX[i]);
        }

        double somaResultIntegral = pointsY[0] + pointsY[subRangeNumber]; // soma dos extremos
        
        //soma dos internos
        for (int i = 1; i < pointsX.length - 1; i++) {
            somaResultIntegral += 2 * pointsY[i];
        }

        somaResultIntegral *= subRangeWidth / 2; // Multiplica pela largura do intervalo e divide por 2

        return somaResultIntegral;
    }

    public static double trapesian_Method_Estimated_Error(int subRangeNumber, double inferiorLimit, double upperLimit) {
        double subRangeWidth = (upperLimit - inferiorLimit) / subRangeNumber;

        // A fórmula para o erro estimado no método dos trapézios é: -(b - a) * h^2 / 12
        double estimatedError = -(upperLimit - inferiorLimit) * Math.pow(subRangeWidth, 2) / 12.0;

        return estimatedError;
    }

}