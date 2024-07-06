import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Empresa extends Usuario {
    private String cnpj;
    private String endereco;
    private String site;
    private String descricao;
    private Area area;

    public Empresa(String login, String nome, String senha, String cnpj) {
        super(login, nome, senha);
        this.cnpj = cnpj;
        this.endereco = null;
    }

    public String toString(){
        return ( this.nome + " ( " + this.login + " - " + this.cnpj + ")" );
    }

    public String getCnpj() {
        return cnpj;
    }
}
