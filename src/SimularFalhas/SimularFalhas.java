package SimularFalhas;

/**
 *
 * @author Veyron-PC
 */
public class SimularFalhas {

    private double constanteFalha = 0.02;
    private int k = 1;

    public SimularFalhas() {
    }

    public SimularFalhas(int tipoFalha, double sinal) {
        switch (tipoFalha) {
            case 1:
                tipoZero();
                break;
            case 2:
                tipoFundoEscala();
                break;
            case 3:
                tipoDeriva(sinal);
                break;
            case 4:
                tipoSemFalha(sinal);
                break;
            default:
                tipoSemFalha(sinal);
                break;
        }
    }

    public double tipoZero() {
        return 0.0;
    }

    public double tipoFundoEscala() {
        return 30.0;
    }

    public double tipoDeriva(double sinal) {
        if (k == 16) {
            k = 0;
        } else {
            k++;
        }
        return sinal * Math.exp(-constanteFalha * k);
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
