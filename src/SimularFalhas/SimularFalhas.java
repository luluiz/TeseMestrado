package SimularFalhas;

/**
 *
 * @author Veyron-PC
 */
public class SimularFalhas {

    private double constanteFalha = 0.02;
    private int k = 1;
    private int x = 0;

    public SimularFalhas() {
    }

    public double SimularFalhas(int tipoFalha, double sinal) {
        switch (tipoFalha) {
            case 1:
                return tipoZero();
            case 2:
                return tipoFundoEscala();
            case 3:
                return tipoDeriva(sinal);
            case 4:
                return tipoSemFalha(sinal);
            default:
                return tipoSemFalha(sinal);
        }
    }

    public double tipoZero() {
        return 0.0;
    }

    public double tipoFundoEscala() {
        return 30.0;
    }

    public double tipoDeriva(double sinal) {
        System.out.println("Falha de Deriva K: " + k);
        if (k == 16) {
            k = 1;
        } else {
            k++;
        }
        return sinal * Math.exp(-constanteFalha * k);
    }

    public double tipoFalhasEmSequencia(double sinal) {
        x++;
        System.out.println("Falhas em Sequencia X: " + x);
        if (x >= 30 && x <= 59) {
            return tipoZero();
        } else if (x >= 60 && x <= 89) {
            return tipoSemFalha(sinal);
        } else if (x >= 90 && x <= 119) {
            return tipoFundoEscala();
        } else if (x >= 120 && x <= 149) {
            return tipoSemFalha(sinal);
        } else if (x >= 150 && x <= 209) {
            return tipoDeriva(sinal);
        } else if (x >= 210 && x <= 239) {
            return tipoSemFalha(sinal);
        } else if (x == 240) {
            x = 0;
        }

        return tipoSemFalha(sinal);
    }

    public double tipoSemFalha(double sinal) {
        return sinal;
    }

    public double getConstanteFalha() {
        return constanteFalha;
    }

    public void setConstanteFalha(double constanteFalha) {
        this.constanteFalha = constanteFalha;
    }

}
