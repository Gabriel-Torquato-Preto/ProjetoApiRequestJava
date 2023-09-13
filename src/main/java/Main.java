import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Titulo>titulos = new ArrayList<>();
        String filme;

        while (true){
            System.out.println("Digite o nome do Filme:");
            filme = scan.nextLine();
            if(filme.equalsIgnoreCase("sair")){
                break;
            }
            try {
                String json = BuscaFilme.retornaJsonPorTitulo(filme);
                Titulo titulo = BuscaFilme.converteJsonParaTitulo(json);
                titulos.add(titulo);
            } catch (IOException|InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(titulos);

    }
}
