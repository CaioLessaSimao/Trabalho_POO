import java.util.Collections;

public class Postagem implements Comparable<Postagem>{
    public String foto;
    public String legenda;
    public Data d;
    public Usuario autor;

    public Postagem(String foto, String legenda, Data hoje, Usuario autor) {
        this.foto = foto;
        this.legenda = legenda;
        this.d = hoje;
        this.autor = autor;
    }

    public void mostrarDados(){
        System.out.println("*");
        System.out.println(this.autor.nome + " (" + this.autor.seguidores.size() + " seguidores)");
        System.out.println(this.foto);
        System.out.println(this.legenda);
        System.out.println(this.d.toString());
    }

    @Override
    public int compareTo(Postagem o) {
        if (this.d.compareTo(o.d) != 0) return  this.d.compareTo(o.d);
        return  (this.autor.compareTo(o.autor));
    }
}
