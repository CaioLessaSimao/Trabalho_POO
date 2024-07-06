import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Empresa extends Usuario implements Salvavel{
    private String cnpj;
    private String endereco;
    private String site;
    private String descricao;
    private Area area;

    public Empresa(String login, String nome, String senha, String cnpj) {
        super(login, nome, senha);
        this.cnpj = cnpj;
        this.endereco = null;
        try {
            FileWriter f = new FileWriter("dados.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            this.salvarArq(b);
            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados");
        }
    }

    @Override
    public void salvarArq(BufferedWriter b) {
        try {
            b.write("P"+"\n");
            b.write(this.login+"\n");
            b.write(this.nome+"\n");
            b.write(this.senha+"\n");
            b.write(this.cnpj+"\n");
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados");
        }
    }

    public String toString(){
        return ( this.nome + " ( " + this.login + " - " + this.cnpj + ")" );
    }

}
