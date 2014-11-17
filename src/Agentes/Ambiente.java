package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Ambiente {

    private double tensaoBomba;
    private double nivelT1;
    private double predT1;
    private double sinalCorrigido;
    private double tipoFalha;

    public Ambiente() {
    }

    public Ambiente(double tensaoBomba, double nivelT1, double predT1, double sinalCorrigido, double tipoFalha) {
        this.tensaoBomba = tensaoBomba;
        this.nivelT1 = nivelT1;
        this.predT1 = predT1;
        this.sinalCorrigido = sinalCorrigido;
        this.tipoFalha = tipoFalha;
    }

    public double getTensaoBomba() {
        return tensaoBomba;
    }

    public void setTensaoBomba(double tensaoBomba) {
        this.tensaoBomba = tensaoBomba;
    }

    public double getNivelT1() {
        return nivelT1;
    }

    public void setNivelT1(double nivelT1) {
        this.nivelT1 = nivelT1;
    }

    public double getPredT1() {
        return predT1;
    }

    public void setPredT1(double predT1) {
        this.predT1 = predT1;
    }

    public double getSinalCorrigido() {
        return sinalCorrigido;
    }

    public void setSinalCorrigido(double sinalCorrigido) {
        this.sinalCorrigido = sinalCorrigido;
    }

    public double getTipoFalha() {
        return tipoFalha;
    }

    public void setTipoFalha(double tipoFalha) {
        this.tipoFalha = tipoFalha;
    }

}
