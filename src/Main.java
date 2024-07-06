import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Sistema s = new Sistema();
        Entrada io = new Entrada(s);

        int op = io.menu1();

        while (op != 0) {
            if (op == 1) {
                io.cadPessoa(s);
            }
            if (op == 2) {
                io.cadEmpresa(s);
            }
            if (op == 3) {
                io.login(s);
            }

            op = io.menu1();
        }
        try {
            FileWriter f = new FileWriter("dados.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            b.write("F"+"\n"+"\n");
            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar os dados");
        }
    }
}