public class Main {
    public static void main(String[] args) {

        Sistema s = new Sistema();
        Entrada e = new Entrada();

        int op = e.menu1();
        while(op != 0){
            switch (op) {
                case 1:
                    e.cadPessoa(s);
                    break;
                case 2:
                    e.cadEmpresa(s);
                    break;
                case 3:
                    e.login(s);
                    break;
            }
            op = e.menu1();
        }
    }
}
