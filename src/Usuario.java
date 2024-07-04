import java.util.ArrayList;
import java.util.Collections;

public abstract class Usuario implements Comparable<Usuario>{
    protected String login;
    protected String nome;
    protected String senha;
    protected Local local;
    protected ArrayList<Postagem> postagens;
    protected ArrayList<Usuario> seguindo;
    protected ArrayList<Usuario> seguidores;

    public Usuario(String login, String nome, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.seguindo = new ArrayList<>();
        this.seguidores = new ArrayList<>();
        this.postagens = new ArrayList<>();
    }

    @Override
    public int compareTo(Usuario o) {
        if (this.seguidores.size() < o.seguidores.size()) return -1;
        if (this.seguidores.size() > o.seguidores.size()) return 1;
        return this.login.compareTo(o.login);
    }

    public boolean validarAcesso(String pwd){
        boolean validation = this.senha.equals(pwd);

        if (!validation){ System.out.println("Senha incorreta"); }
        return validation;
    }

    public String toString(){
        return (this.nome + " - (" + this.login + " ");
    }

    public void postar(String foto, String legenda, Data hoje, String senha, Usuario autor){
        if(validarAcesso(senha)){
            Postagem p = new Postagem(foto, legenda, hoje, autor);
            this.postagens.add(p);
        }
    }

    public void seguir(Usuario u){
        this.seguindo.add(u);
        u.seguidores.add(this);
    }

    public static void mostrarPosts(ArrayList<Postagem> posts){
        Collections.sort(posts);
        for (Postagem p: posts) {
            p.mostrarDados();
        }
        System.out.println("*");
    }

    public void feed(){
        ArrayList<Postagem> postsFeed = new ArrayList<>();
        for (Usuario u: this.seguindo) {
            postsFeed.addAll(u.postagens);
        }
        System.out.println(' ');
        System.out.println("Feed de " + this.nome + ":");
        Usuario.mostrarPosts(postsFeed);
    }
}
