import com.google.gson.annotations.SerializedName;

public class Titulo {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private String anoDeLancamento;
    private boolean incluidoNoPlano;

    @Override
    public String toString() {
        return  "{" +
                "\"nome:\"" + nome +","+
                "\"anoDeLancamento:\"" + anoDeLancamento +","+
                "\"duracaoEmMinutos:\"" + duracaoEmMinutos + "}"
                ;
    }

    private double SomaDasAvaliacoes;
    @SerializedName("Runtime")
    private int duracaoEmMinutos;

    public Titulo(String nome, String anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOMDB tituloOMDB){
        this.nome = tituloOMDB.title();
        this.anoDeLancamento = tituloOMDB.year();
        this.duracaoEmMinutos = Integer.parseInt(tituloOMDB.runtime().replace("min", "").trim());


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
}
