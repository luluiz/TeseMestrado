package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Diagnostico extends Ambiente {

    private String nome = "Agente de Predição";
    private double saidaAgenteDiagnostico;

    public Agente_de_Diagnostico() {
    }

    public Agente_de_Diagnostico(double tensaoBomba, double nivelT1, double saidaAgenteDiagnostico) {
        this.setTensaoBomba(tensaoBomba);
        this.setNivelT1(nivelT1);
        this.saidaAgenteDiagnostico = saidaAgenteDiagnostico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaidaAgenteDiagnostico() {
        return saidaAgenteDiagnostico;
    }

    public void setSaidaAgenteDiagnostico(double saidaAgenteDiagnostico) {
        this.saidaAgenteDiagnostico = saidaAgenteDiagnostico;
    }

}
