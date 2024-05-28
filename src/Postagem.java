public class Postagem {
    public String foto;
    public String legenda;
    public Data d;

    public Postagem(String foto, String legenda, Data hoje) {
        this.foto = foto;
        this.legenda = legenda;
        this.d = hoje;
    }

    public void mostrarDados(){
        System.out.println(this.foto);
        System.out.println(this.legenda + " - " + this.d.toString());;
    }
}
