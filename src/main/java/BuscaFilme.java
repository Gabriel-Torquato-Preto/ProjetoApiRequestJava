import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaFilme {

    public static String retornaJsonPorTitulo(String titulo) throws IOException, InterruptedException{
    String apiKey = "ae46bdc5";
    String url = "https://www.omdbapi.com/?t="+titulo+"&apikey="+apiKey;
    url = url.replace(" ", "+");

    HttpClient htpp = HttpClient.newBuilder().proxy(ProxySelector.of(new InetSocketAddress("proxy.br.bosch.com", 8080))).build();

    HttpRequest resquest = HttpRequest.newBuilder().uri(URI.create(url)).build();

    HttpResponse<String> response = htpp.send(resquest, HttpResponse.BodyHandlers.ofString());
    return response.body();

    }
    public static Titulo  converteJsonParaTitulo(String titulo1){
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOMDB titulo = gson.fromJson(titulo1, TituloOMDB.class);
        Titulo meuTitulo = new Titulo(titulo);

        System.out.println(meuTitulo);

        return meuTitulo;

    }


}
