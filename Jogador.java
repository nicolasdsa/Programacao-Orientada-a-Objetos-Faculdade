package SuperTrunfoDaReciclagem;

import java.util.Stack;

public class Jogador {
    private String nome;
    private Stack<Carta> cartas;

    public Jogador(String nome){
        this.nome = nome;
        cartas = new Stack<Carta>();
    }

    public String nome() {
        return this.nome;
    }

    public Carta espiar() {
        return this.cartas.peek();
    }

    public Integer numeroDeCartas() {
        return this.cartas.size();
    }

    public void incluir(Carta carta) {
        cartas.add(0, carta);
    }

    public Carta excluir() {
        if(!cartas.empty()){
            Carta cartaTemp = cartas.pop();
            return cartaTemp;
        }
        return null;
    }

    public Boolean temCartas() {
        if (!this.cartas.empty()){
            return true;
        }else{
            return false;
        }
    }
    
}
