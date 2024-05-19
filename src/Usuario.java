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
}
