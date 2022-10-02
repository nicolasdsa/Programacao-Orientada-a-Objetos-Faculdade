package SuperTrunfoDaReciclagem;

public abstract class Carta {
    private String código;
    private String nome;
    private String descricao;
    private String tipo;
    private Cor cor;
    private Double decomposicao;
    private Integer ataque;

    public Carta(String codigo, String nome, String descricao, String tipo, Cor cor, Double decomposicao, Integer ataque){
        this.código = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.cor = cor;
        this.decomposicao = decomposicao;
        this.ataque = ataque;
    }

    public String getCodigo() {
        return this.código;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Integer getAtaque() {
        return this.ataque;
    }

    public Cor getCor() {
        return this.cor;
    }

    public void printarCarta() {
        System.out.println(this.código + " " + this.nome);
        System.out.println("\t descrição: " + this.descricao);
        System.out.println("\t cor: " + this.cor);
        System.out.println("\t decomposição: " + this.decomposicao);
        System.out.println("\t reciclavel: " + this.ehReciclavel());
        System.out.println("\t ataque: " + this.ataque);
        
    }

    public abstract Boolean ehReciclavel();

    public String toString() {
        return this.nome;
    }

    public Integer comparaDecomposicao(Carta carta_inimiga) {
        if(carta_inimiga.decomposicao > this.decomposicao){
            return 1;
        }
        else if(this.decomposicao > carta_inimiga.decomposicao){
            return -1;
        }else{
            return 0;
        }
    }

    public Integer comparaReciclavel(Carta carta_inimiga) {
        if(this.ehReciclavel() && !carta_inimiga.ehReciclavel()){
            return 1;
        }
        else if(!this.ehReciclavel() && carta_inimiga.ehReciclavel()){
            return -1;
        }else{
            return 0;
        }
    }

    public Integer comparaAtaque(Carta carta_inimiga) {
        if(this.ataque > carta_inimiga.ataque){
            return 1;
        }
        else if(this.ataque < carta_inimiga.ataque){
            return -1;
        }else{
            return 0;
        }
    }

    public Integer comparaCor(Carta carta_inimiga) {
        if(this.cor.equals(carta_inimiga.cor) || 
                                                this.cor == Cor.VERMELHO && carta_inimiga.cor == Cor.PRETO || 
                                                this.cor == Cor.CINZA && carta_inimiga.cor == Cor.AZUL ||
                                                this.cor == Cor.AMARELO && carta_inimiga.cor == Cor.BRANCO ||
                                                this.cor == Cor.VERDE && carta_inimiga.cor == Cor.LARANJA ||
                                                this.cor == Cor.MARROM && carta_inimiga.cor == Cor.ROXO ||

                                                this.cor == Cor.PRETO && carta_inimiga.cor == Cor.VERMELHO || 
                                                this.cor == Cor.AZUL && carta_inimiga.cor == Cor.CINZA ||
                                                this.cor == Cor.BRANCO && carta_inimiga.cor == Cor.AMARELO ||
                                                this.cor == Cor.LARANJA && carta_inimiga.cor == Cor.VERDE ||
                                                this.cor == Cor.ROXO && carta_inimiga.cor == Cor.MARROM){
            return 0;
        }
        if(this.cor == Cor.VERMELHO && (carta_inimiga.cor == Cor.AMARELO ||
                                        carta_inimiga.cor == Cor.VERDE ||
                                        carta_inimiga.cor == Cor.MARROM ||
                                        carta_inimiga.cor == Cor.CINZA)){
            return 1;
        }

        else if(this.cor == Cor.AZUL && (carta_inimiga.cor == Cor.VERMELHO ||
                                        carta_inimiga.cor == Cor.AMARELO ||
                                        carta_inimiga.cor == Cor.VERDE ||
                                        carta_inimiga.cor == Cor.MARROM)){
            return 1;
        }

        else if(this.cor == Cor.AMARELO && (carta_inimiga.cor == Cor.VERDE ||
                                        carta_inimiga.cor == Cor.MARROM ||
                                        carta_inimiga.cor == Cor.CINZA ||
                                        carta_inimiga.cor == Cor.PRETO)){
            return 1;
        }

        else if(this.cor == Cor.VERDE && (carta_inimiga.cor == Cor.CINZA ||
                                        carta_inimiga.cor == Cor.PRETO ||
                                        carta_inimiga.cor == Cor.BRANCO ||
                                        carta_inimiga.cor == Cor.MARROM)){
            return 1;
        }

        else if(this.cor == Cor.CINZA && (carta_inimiga.cor == Cor.PRETO ||
                                        carta_inimiga.cor == Cor.BRANCO ||
                                        carta_inimiga.cor == Cor.LARANJA ||
                                        carta_inimiga.cor == Cor.ROXO)){
            return 1;
        }

        else if(this.cor == Cor.LARANJA && (carta_inimiga.cor == Cor.ROXO ||
                                        carta_inimiga.cor == Cor.AZUL ||
                                        carta_inimiga.cor == Cor.VERMELHO ||
                                        carta_inimiga.cor == Cor.AMARELO)){
            return 1;
        }

        else if(this.cor == Cor.MARROM && (carta_inimiga.cor == Cor.CINZA ||
                                        carta_inimiga.cor == Cor.PRETO ||
                                        carta_inimiga.cor == Cor.BRANCO ||
                                        carta_inimiga.cor == Cor.LARANJA)){
            return 1;
        }

        else if(this.cor == Cor.ROXO && (carta_inimiga.cor == Cor.AZUL ||
                                        carta_inimiga.cor == Cor.VERMELHO ||
                                        carta_inimiga.cor == Cor.AMARELO ||
                                        carta_inimiga.cor == Cor.VERDE)){
            return 1;
        }

        else if(this.cor == Cor.BRANCO && (carta_inimiga.cor == Cor.LARANJA ||
                                        carta_inimiga.cor == Cor.ROXO ||
                                        carta_inimiga.cor == Cor.AZUL ||
                                        carta_inimiga.cor == Cor.VERMELHO)){
            return 1;
        }

        else if(this.cor == Cor.PRETO && (carta_inimiga.cor == Cor.BRANCO ||
                                        carta_inimiga.cor == Cor.LARANJA ||
                                        carta_inimiga.cor == Cor.ROXO ||
                                        carta_inimiga.cor == Cor.AZUL)){
            return 1;
        }
    
        return -1;
    }
    
}
