package SuperTrunfoDaReciclagem;

public class Reciclavel extends Carta{

    public Reciclavel(String codigo, String nome, String descricao, String tipo, Cor cor, Double decomposicao, Integer ataque){
        super(codigo, nome, descricao, tipo, cor, decomposicao, ataque);
    }

    public Boolean ehReciclavel() {
        return true;
    }

    public String toString() {
        return super.toString() + "\nReciclavel";
    }
}
