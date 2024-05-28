import java.util.ArrayList;

public class Pessoa extends Usuario{
    private String cpf;
    private Data dtNasc;
    private String bio;
    private ArrayList<Usuario> interesses;

    public Pessoa( String login, String nome, String senha, String cpf, int dia, int mes, int ano ) {
        super(login, nome, senha);
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.dtNasc = new Data(dia,mes,ano);
        this.interesses = new ArrayList<>();
    }

    public String toString(){
        return ( this.nome + " ( " + this.login + " - " + this.cpf + ")" );
    }
}
