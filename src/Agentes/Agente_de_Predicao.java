package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Predicao extends Ambiente {

    private String nome = "Agente de Predição";
    private double saidaAgentePredicao;

    public Agente_de_Predicao() {

    }

    public Agente_de_Predicao(double tensaoBomba, double nivelT1, double saida) {
        this.setTensaoBomba(tensaoBomba);
        this.setNivelT1(nivelT1);
        this.saidaAgentePredicao = saida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaidaAgentePredicao() {
        return saidaAgentePredicao;
    }

    public void setSaidaAgentePredicao(double saidaAgentePredicao) {
        this.saidaAgentePredicao = saidaAgentePredicao;
    }

}
