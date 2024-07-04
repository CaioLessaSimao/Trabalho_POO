import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sistema {
    public ArrayList<Pessoa> pessoas;
    public ArrayList<Empresa> empresas;

    public Sistema() {
        this.pessoas = new ArrayList<>();
        this.empresas = new ArrayList<>();
    }

    public Usuario buscarUsuario(String login){
        for(Pessoa p : this.pessoas){
            if(p.login.equals(login)){
                return p;
            }
        }
        for(Empresa emp : this.empresas){
            if(emp.login.equals(login)){
                return emp;
            }
        }
        return null;
    }

    public void novaPessoa(Pessoa p){
        this.pessoas.add(p);
    }

    public void novaEmpresa(Empresa emp){
        this.empresas.add(emp);
    }

    public void listarUsuarios(){

        int i = 1;
        System.out.println("Listando empresas:");
        for (Empresa e: this.empresas){
            System.out.println(i + ": " + e.toString());
            i++;
        }

        System.out.println("Listando pessoas");
        for (Pessoa p: this.pessoas){
            System.out.println(i + ": " + p.toString());
            i++;
        }
    }
}
