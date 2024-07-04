import java.time.LocalDateTime;
public class Data implements Comparable<Data> {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return ( Integer.toString(this.dia) + "/" + Integer.toString(this.mes) + "/" + Integer.toString(ano));
    }

    @Override
    public int compareTo(Data o) {
        if (this.ano < o.ano) return -1;
        if (this.ano > o.ano) return 1;
        if (this.mes < o.mes) return -1;
        if (this.mes > o.mes) return 1;
        if (this.dia < o.dia) return -1;
        if (this.dia > o.dia) return 1;
        return 0;
    }
}
