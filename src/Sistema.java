import java.util.ArrayList;

public class Sistema {
    public ArrayList<Pessoa> pessoas;
    public ArrayList<Empresa> empresas;



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
}
