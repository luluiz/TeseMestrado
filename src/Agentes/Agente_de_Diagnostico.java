package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Diagnostico extends Ambiente {

    private String nome = "Agente de Predição";
    private double tipoFalha;
    private boolean flagFalha = false;

    public Agente_de_Diagnostico() {
    }

    public Agente_de_Diagnostico(double tensaoBomba, double nivelT1, double tipoFalha) {
        this.setTensaoBomba(tensaoBomba);
        this.setNivelT1(nivelT1);
        this.tipoFalha = tipoFalha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaidaAgenteDiagnostico() {
        return tipoFalha;
    }

    public void setSaidaAgenteDiagnostico(double saidaAgenteDiagnostico) {
        this.tipoFalha = saidaAgenteDiagnostico;
    }

    public boolean isFlagFalha() {
        return flagFalha;
    }

    public void setFlagFalha(boolean flagFalha) {
        this.flagFalha = flagFalha;
    }

}
