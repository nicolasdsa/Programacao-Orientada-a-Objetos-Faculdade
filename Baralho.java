package SuperTrunfoDaReciclagem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;

public class Baralho {
    public List<Carta> cartas;
    public Random rastrear;
    

    public Baralho(){
        cartas = new ArrayList<>();
        lerDoArquivo();
        rastrear = new Random();
    }

    public int numeroDeCartas() {
        return cartas.size();
    }

    public Carta selecionaCarta() {
        Carta carta_temp = null;
        if (cartas.size()>0){
            carta_temp = cartas.remove(rastrear.nextInt(cartas.size()));
        }
        return carta_temp;
    }

    private final void lerDoArquivo(){
        BufferedReader csvReader = null;


        try{
            csvReader = new BufferedReader(new FileReader("C:\\Users\\johnn\\Documents\\Codes\\POO\\SuperTrunfoDaReciclagem\\Cartas.csv"));
            String row = "";

            while ((row = csvReader.readLine()) != null) {
                
                cartas.add(criarCarta(row));            }
            csvReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final Carta criarCarta(String linha){
        String[] quebrado = linha.split(";");
        if (quebrado[7] == "sim"){
            return new Reciclavel(
                quebrado[0],
                quebrado[1],
                quebrado[2],
                quebrado[3],
                Cor.stringToCor(quebrado[4]),
                Double.parseDouble(quebrado[5]),
                Integer.parseInt(quebrado[6])
            );
        }else{
            return new NaoReciclavel(
                quebrado[0],
                quebrado[1],
                quebrado[2],
                quebrado[3],
                Cor.stringToCor(quebrado[4]),
                Double.parseDouble(quebrado[5]),
                Integer.parseInt(quebrado[6])
            );
        }
    }
    
    public String toString() {
        return cartas.toString();
    }
}

