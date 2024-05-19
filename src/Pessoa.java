public class Pessoa extends Usuario{
    private String cpf;
    private Data dtNasc;
    private String bio;
    private Usuario[] interesses;

    public Pessoa( String login, String nome, String senha, String cpf, int dia, int mes, int ano ) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        Data d = new Data(dia,mes,ano);
        this.dtNasc = d;
    }
}
