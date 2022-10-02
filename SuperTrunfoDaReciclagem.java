package SuperTrunfoDaReciclagem;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class SuperTrunfoDaReciclagem{
    private static Jogador[] jogadores = new Jogador[2];

    public static void prepararJogo() {
        //Prepara toda as variáveis que serão usadas no jogo
        //Lê os nomes dos jogadores
        //Distribui as cartas entre os jogadores
        
        String tipoDeJogo = "";

        Baralho baralho = new Baralho();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do Jogador 1:");
        String nome = sc.nextLine();
        jogadores[0] = new Jogador(nome);
        

        System.out.println("Digite o nome do Jogador 2:");
        nome = sc.nextLine();
        jogadores[1] = new Jogador(nome);
        Integer totalCartas = baralho.cartas.size();

        for(int i=0;i<totalCartas/2;i++){
            jogadores[0].incluir(baralho.selecionaCarta());
            jogadores[1].incluir(baralho.selecionaCarta());
        }

        do {
            System.out.println("Digite o tipo de modo de jogo:\n\t1 - Jogo Extreme Fodas\n\t2 - Simulacao");
            tipoDeJogo = sc.next();
            System.out.println(tipoDeJogo);
        } while (!tipoDeJogo.equals("1") && !tipoDeJogo.equals("2"));
        

        iniciarJogo(jogadores[0], jogadores[1], tipoDeJogo);
    }

    public static void iniciarJogo(Jogador player1, Jogador player2, String tipoDeJogo) {
        Integer contador = 0;
        Integer player_da_rodada = 1;
        Stack<Carta> cartasEmpatadas;

        cartasEmpatadas = new Stack<>();

        System.out.println("Rodada numero : "+ contador);
        contador++;

        //Sorteia o player que irá iniciar a rodada
        Random sorteio = new Random();
        if(sorteio.nextInt(2) == 0){
            System.out.println("Player 1 começa");
            player_da_rodada = 1;
        }else{
            System.out.println("Player 2 começa");
            player_da_rodada = -1;
        }

        rodadaDoPlayer(player_da_rodada, player1, player2, tipoDeJogo, cartasEmpatadas);
        

        while(player1.temCartas() && player2.temCartas()){
            System.out.println("\n\n-----------------------------------------------------------------------------\n\n");

            System.out.println("\tCartas do "+player1.nome()+": "+player1.numeroDeCartas()+" cartas do "+player2.nome()+": "+player2.numeroDeCartas());
            System.out.println("\tNumero de cartas empatadas: "+ cartasEmpatadas.size());

            System.out.print("[");
            for(int i = 0; i < cartasEmpatadas.size(); i++){
                System.out.print(cartasEmpatadas.get(i).getNome()+"; ");
            }
            System.out.println("]\n");
            
            System.out.println("\t\tRodada numero : "+ contador+"\n");
            contador++;    
            player_da_rodada *= -1;
            rodadaDoPlayer(player_da_rodada, player1, player2, tipoDeJogo, cartasEmpatadas);
        }

        System.out.println("\n\n");
        if(player1.temCartas().equals(false) && player2.temCartas().equals(false)){
            System.out.println("O jogo terminou empatado");
        }
        else if(player1.numeroDeCartas() > player2.numeroDeCartas()){
            System.out.println("O player: "+player1.nome()+" ganhou... parabéns!!!");
        }else{
            System.out.println("O player: "+player2.nome()+" ganhou... parabéns!!!");
        }
    }

    public static Stack<Carta> comparacoesP1(String op, Jogador player1, Jogador player2, Stack<Carta> cartasEmpatadas) {
        if(op.equals("1")){
            System.out.println(player1.nome()+" ganhou");
            player1.incluir(player2.excluir());
            player1.incluir(player1.excluir());

            while(!cartasEmpatadas.empty()){
                player1.incluir(cartasEmpatadas.pop());
            }
        }
        else if(op.equals("-1")){
            System.out.println(player2.nome()+" ganhou");
            player2.incluir(player1.excluir());
            player2.incluir(player2.excluir());

            while(!cartasEmpatadas.empty()){
                player2.incluir(cartasEmpatadas.pop());
            }
        }else{
            System.out.println("Empatou");
            cartasEmpatadas.add(player1.excluir());
            cartasEmpatadas.add(player2.excluir());
        }

        return cartasEmpatadas;
    }

    public static Stack<Carta> comparacoesP2(String op, Jogador player1, Jogador player2, Stack<Carta> cartasEmpatadas) {
        if(op.equals("1")){
            System.out.println(player2.nome()+" ganhou");
            player2.incluir(player1.excluir());
            player2.incluir(player2.excluir());

            while(!cartasEmpatadas.empty()){
                player2.incluir(cartasEmpatadas.pop());
            }
        }
        else if(op.equals("-1")){
            System.out.println(player1.nome()+" ganhou");
            player1.incluir(player2.excluir());
            player1.incluir(player1.excluir());

            while(!cartasEmpatadas.empty()){
                player1.incluir(cartasEmpatadas.pop());
            }
        }else{
            System.out.println("Empatou");
            cartasEmpatadas.add(player1.excluir());
            cartasEmpatadas.add(player2.excluir());
        }

        return cartasEmpatadas;
    }

    public static void rodadaDoPlayer(Integer player_da_rodada, Jogador player1, Jogador player2, String tipoDeJogo, Stack<Carta> cartasEmpatadas) {
        
        if(player_da_rodada == 1){
            System.out.println("Carta do "+player1.nome()+":");
            player1.espiar().printarCarta();

            System.out.println("");

            System.out.println("Escolha o atributo a ser comparado:");
            System.out.println("\t Cor - 0");
            System.out.println("\t Decomposicao - 1");
            System.out.println("\t Reciclavel - 2");
            System.out.println("\t Ataque - 3");

            String op = "";
            
            if(tipoDeJogo.equals("1")){
                do {
                    Scanner sc = new Scanner(System.in);
                    op = sc.next();
                    
                } while (!op.equals("0") && !op.equals("1") && !op.equals("2") && !op.equals("3"));
            }else{
                Random sorteio = new Random();
                op = String.valueOf(sorteio.nextInt(4));
                System.out.println("Opcao sorteada: "+op);
                System.out.println("");
            }
            
            System.out.println("Carta do "+player2.nome()+":");
            player2.espiar().printarCarta();
            
            if(player1.espiar().getNome().equals("Super Pneu") && op == "0"){
                op = "-1";
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
            }
            else if(player2.espiar().getNome().equals("Super Pneu") && op == "0"){
                op = "-1";
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
            }
            else if(player2.espiar().getNome().equals("Dom Laton")){
                if(player1.espiar().getCodigo().charAt(1) == '1'){
                    op = "-1";
                    cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
                }
                else{
                    op = "1";
                    cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
                }
            }
            else if(player1.espiar().getNome().equals("Dom Laton")){
                if(player2.espiar().getCodigo().charAt(1) == '1'){
                    op = "-1";
                    cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                }
                else{
                    op = "1";
                    cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                }
            }
            else if(op.equals("0")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player1.espiar().comparaCor(player2.espiar()));
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                
            }
            else if(op.equals("1")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player1.espiar().comparaDecomposicao(player2.espiar()));
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                
            }
            else if(op.equals("2")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player1.espiar().comparaReciclavel(player2.espiar()));
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);

            }
            else if(op.equals("3")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player1.espiar().comparaAtaque(player2.espiar()));
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);

            }

        }
        else if(player_da_rodada == -1){
            System.out.println("Carta do "+player2.nome()+":");
            player2.espiar().printarCarta();

            System.out.println("");

            System.out.println("Escolha o atributo a ser comparado:");
            System.out.println("\t Cor - 0");
            System.out.println("\t Decomposicao - 1");
            System.out.println("\t Reciclavel - 2");
            System.out.println("\t Ataque - 3");

            String op;
            if(tipoDeJogo.equals("1")){
                do {
                    Scanner sc = new Scanner(System.in);
                    op = sc.next();
                    
                } while (!op.equals("0") && !op.equals("1") && !op.equals("2") && !op.equals("3"));
            }else{
                Random sorteio = new Random();
                op = String.valueOf(sorteio.nextInt(4));
                System.out.println("Opcao sorteada: "+op);
                System.out.println("");
            }

            System.out.println("Carta do "+player1.nome()+":");
            player1.espiar().printarCarta();
                        
            if(player1.espiar().getNome().equals("Super Pneu") && op == "0"){
                op = "-1";
                cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
            }
            else if(player2.espiar().getNome().equals("Super Pneu") && op == "0"){
                op = "-1";
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
            }
            else if(player1.espiar().getNome().equals("Dom Laton")){
                if(player2.espiar().getCodigo().charAt(1) == '1'){
                    op = "-1";
                    cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                }
                else{
                    op = "1";
                    cartasEmpatadas = comparacoesP1(op, player1, player2, cartasEmpatadas);
                }
            }
            else if(player2.espiar().getNome().equals("Dom Laton")){
 
                if(player1.espiar().getCodigo().charAt(1) == '1'){
                    op = "-1";
                    cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
                }
                else{
                    op = "1";
                    cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
                }
            }
            else if(op.equals("0")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player2.espiar().comparaCor(player1.espiar()));
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);                
            }
            else if(op.equals("1")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player2.espiar().comparaDecomposicao(player1.espiar()));
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);                
            }
            else if(op.equals("2")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player2.espiar().comparaReciclavel(player1.espiar()));
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
            }
            else if(op.equals("3")){
                //Comparando a carta do player1(atacante) com a do player 2(atacado)
                //Se o atacante ganhar retorna 1 || Se o atacado ganhar retorna -1 || Se empatar retorna 0
                op = String.valueOf(player2.espiar().comparaAtaque(player1.espiar()));
                cartasEmpatadas = comparacoesP2(op, player1, player2, cartasEmpatadas);
            }
        }
    }
    public static void main(String[] args) {
        prepararJogo();
        
    }

}