package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Correcao extends Ambiente {

    private String nome = "Agente de Correção";
    private double sinalCorrigido;

    public Agente_de_Correcao() {
    }

    public Agente_de_Correcao(double sinalCorrigido) {
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
