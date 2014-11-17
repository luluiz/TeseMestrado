package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Execucao extends Ambiente {

    private String nome = "Agente de Execução";
    private double sinalCorrigido;

    public Agente_de_Execucao() {
    }

    public Agente_de_Execucao(double sinalCorrigido) {
        this.sinalCorrigido = sinalCorrigido;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public double getSinalCorrigido() {
        return sinalCorrigido;
    }

}
