package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Decisao extends Ambiente {

    private String nome = "Agente de Decisão";
    private boolean habilitarCorrecao = false;

    public Agente_de_Decisao() {
    }

    public Agente_de_Decisao(double tensaoBomba, double nivelT1, double predT1, double sinalCorrigido, double tipoFalha) {
        this.setNivelT1(nivelT1);
        this.setPredT1(predT1);
        this.setTensaoBomba(tensaoBomba);
        this.setSinalCorrigido(sinalCorrigido);
        this.setTipoFalha(tipoFalha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean habilitarCorrecao() {
        if (this.getTipoFalha() != 4) {  // pode colocar entre 3.5 e 4.0
            return habilitarCorrecao = true;
        } else {
            return habilitarCorrecao = false;
        }
    }
}
