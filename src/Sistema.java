import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sistema {
    public ArrayList<Pessoa> pessoas;
    public ArrayList<Empresa> empresas;
    public ArrayList<Usuario> usuarios;

    public Sistema() {
        this.pessoas = new ArrayList<>();
        this.empresas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
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
    public void salvar(BufferedWriter b){
        this.usuarios.addAll(this.pessoas);
        this.usuarios.addAll(this.empresas);

        for(Pessoa p: this.pessoas){
            try {
                b.write("P"+"\n");
                b.write(p.login+"\n");
                b.write(p.nome+"\n");
                b.write(p.senha+"\n");
                b.write(p.getCpf()+"\n");
                b.write(p.getDtNasc().getDia()+"\n");
                b.write(p.getDtNasc().getMes()+"\n");
                b.write(p.getDtNasc().getAno()+"\n");
            }
            catch (IOException e){
                System.out.println("Erro ao salvar os dados");
            }
        }

        for(Empresa emp: this.empresas){
            try {
                b.write("E"+"\n");
                b.write(emp.login+"\n");
                b.write(emp.nome+"\n");
                b.write(emp.senha+"\n");
                b.write(emp.getCnpj()+"\n");
            }
            catch (IOException e){
                System.out.println("Erro ao salvar os dados");
            }
        }
        for (Usuario u : this.usuarios){
            for (Usuario usu : u.seguindo){
                u.salvarArq(b);
                try {
                    b.write(usu.login + "\n");
                }
                catch (IOException e){
                    System.out.println("Erro ao salvar os dados");
                }
            }
        }
    }
}
