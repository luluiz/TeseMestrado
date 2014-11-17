package Agentes;

/**
 *
 * @author Veyron-PC
 */
public class Agente_de_Decisao extends Ambiente {

    private String nome = "Agente de Decisão";
    private boolean flagFalha = false;

    public Agente_de_Decisao() {
    }

    public Agente_de_Decisao(double tensaoBomba, double nivelT1, double predT1, double sinalCorrigido, double tipoFalha) {
        this.setNivelT1(nivelT1);
        this.setPredT1(predT1);
        this.setTensaoBomba(tensaoBomba);
        this.setSinalCorrigido(sinalCorrigido);
        this.setTipoFalha(tipoFalha);
        isFlagFalha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFlagFalha() {
        if (this.getTipoFalha() <= 4 && this.getTipoFalha() >= 3.5) {  // pode colocar entre 3.5 e 4.0
            return flagFalha = true;
        } else {
            return flagFalha = false;
        }
    }
}
