import java.time.LocalDateTime;
public class Data {
    private int dia, mes, ano;

    public Data(){
        LocalDateTime now = LocalDateTime.now();
        this.dia = now.getDayOfMonth();
        this.mes = now.getMonthValue();
        this.ano = now.getYear();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {

        return ( Integer.toString(this.dia) + "/" + Integer.toString(this.mes) + "/" + Integer.toString(ano));
    }
}
