package SuperTrunfoDaReciclagem;

public class NaoReciclavel extends Carta{

    public NaoReciclavel(String codigo, String nome, String descricao, String tipo, Cor cor, Double decomposicao, Integer ataque){
        super(codigo, nome, descricao, tipo, cor, decomposicao, ataque);
    }

    public Boolean ehReciclavel() {
        return false;
    }

    public String toString() {
        return super.toString() + "\nNao Reciclavel";
    }
}
