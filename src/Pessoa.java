import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pessoa extends Usuario implements Salvavel{
    private String cpf;
    private Data dtNasc;
    private String bio;
    private ArrayList<Usuario> interesses;

    public Pessoa( String login, String nome, String senha, String cpf, int dia, int mes, int ano ) {
        super(login, nome, senha);
        this.cpf = cpf;
        this.dtNasc = new Data(dia,mes,ano);
        this.interesses = new ArrayList<>();
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

    public String toString(){
        return ( this.nome + " ( " + this.login + " - " + this.cpf + ")" );
    }


    public void salvarArq(BufferedWriter b) {
        try {
            b.write("P");
            b.write("\n");
            b.write(this.login);
            b.write("\n");
            b.write(this.nome);
            b.write("\n");
            b.write(this.senha);
            b.write("\n");
            b.write(this.cpf);
            b.write("\n");
            b.write(this.dtNasc.getDia());
            b.write("\n");
            b.write(this.dtNasc.getMes());
            b.write("\n");
            b.write(this.dtNasc.getAno());
            b.write("\n");
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados");
        }
    }
}
