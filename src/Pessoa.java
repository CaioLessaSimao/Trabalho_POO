public class Pessoa extends Usuario{
    private String cpf;
    private Data dtNasc;
    private String bio;
    private Usuario[] interesses;

    public Pessoa( String login, String nome, String senha, String cpf, int dia, int mes, int ano ) {
        super(login, nome, senha);
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.dtNasc = new Data(dia,mes,ano);
    }

    public String toString(){
        return ( this.nome + " ( " + this.login + " - " + this.cpf + ")" );
    }
}
