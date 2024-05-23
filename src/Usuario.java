import java.util.ArrayList;

public class Usuario {
    protected String login;
    protected String nome;
    protected String senha;
    protected Local local;
    protected ArrayList<Postagem> postagens;
    protected ArrayList<Usuario> seguindo;
    protected ArrayList<Usuario> seguidores;
    protected ArrayList<Usuario> interessados;

    public Usuario(String login, String nome, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }



    public boolean validarAcesso(String pwd){
        boolean validation = this.senha.equals(pwd);

        if (!validation){ System.out.println("Senha incorreta"); }
        return validation;
    }

    public String toString(){
        return (this.nome + " - (" + this.login + " ");
    }

    public void postar(String foto, String legenda, Data hoje, String senha){
        if(validarAcesso(senha)){
            Postagem p = new Postagem(foto, legenda, hoje);
            this.postagens.add(p);
        }
    }

    public void seguir(Usuario u){
        this.seguindo.add(u);
        u.seguidores.add(this);
    }

    public void mostrarPosts(){
        for (Postagem p: this.postagens) {
            System.out.println(' ');
            p.mostrarDados();
        }
    }

    public void feed(){
        for (Usuario u: this.seguindo) {
            System.out.println(' ');
            System.out.println("Usuario: " + u.nome);
            u.mostrarPosts();
        }
    }
}
