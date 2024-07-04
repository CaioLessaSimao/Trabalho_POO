import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e <seu nome aqui>
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada(Sistema s) {
        try{
            this.input = new Scanner((new FileInputStream(("dados.txt"))));
            this.importarDados(s);
        } catch (FileNotFoundException e) {
            System.out.println("nao encontrou arquivos salvos");
        }

        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar pessoa.\n" +
                "2) Cadastrar empresa.\n" +
                "3) Login.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    public int menu2(Sistema s, Usuario u){

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Seguir Usuário.\n" +
                "2) Fazer postagem.\n" +
                "3) Exibir feed.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /**
     * Lê os dados de uma nova Pessoa e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadPessoa(Sistema s) {
        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cpf = this.lerLinha("Digite seu cpf: ");
        int dia = this.lerInteiro("Digite seu dia de nascimento: ");
        int mes = this.lerInteiro("Digite seu mes de nascimento: ");
        int ano = this.lerInteiro("Digite seu ano de nascimento: ");

        Pessoa p = new Pessoa(login, nome, senha, cpf, dia, mes, ano);
        s.novaPessoa(p);
    }

    public void cadEmpresa(Sistema s) {
        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite o nome da empresa: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cnpj = this.lerLinha("Digite seu cnpj: ");
        //String endereco = this.lerLinha("Digite o endereco da empresa: ");


        Empresa emp = new Empresa(login, nome, senha, cnpj);
        s.novaEmpresa(emp);
    }

    public void cadPostagem(Sistema s, Usuario u){
        String nomeFoto,legenda,senha;
        int dia, mes, ano;

        nomeFoto = lerLinha("Digite o nome da foto: ");
        legenda = lerLinha("Digite a legenda do post: ");
        dia = lerInteiro("digite o dia: ");
        mes = lerInteiro("digite o mes: ");
        ano = lerInteiro("digite o ano: ");
        senha = lerLinha("Digite sua senha: ");

        u.postar(nomeFoto,legenda, new Data(dia, mes, ano), senha, u);
    }


    private void executarMenu2(Sistema s, Usuario u, int op){
        switch (op){
            case 1:

                s.listarUsuarios();

                String buscado = this.lerLinha("Digite o login do usuário que deseja seguir: ");
                Usuario b = s.buscarUsuario(buscado);
                if (b != null){
                    u.seguir(b);
                }

                break;

            case 2:
                this.cadPostagem(s,u);
                break;

            case 3:
                u.feed();
                break;

        }
    }

    public void login(Sistema s){
        String login = lerLinha("Digite seu login: ");
        String senha = lerLinha("Digite sua senha: ");

        Usuario u = s.buscarUsuario(login);
        if (u != null){
            if (u.validarAcesso(senha)){

                int op = this.menu2(s, u);
                while (op != 0){
                    executarMenu2(s, u, op);
                    op = this.menu2(s, u);
                }
            }
        }
    }

    private void importarDados(Sistema s){
        String op = this.lerLinha("Digite a opção");

        while( !op.equals("F") ) {
            switch (op) {
                case "P" -> cadPessoa(s);
                case "E" -> cadEmpresa(s);
                case "S" -> s.buscarUsuario(lerLinha("")).seguir(s.buscarUsuario(lerLinha("")));
            }
            op = this.lerLinha("");
        }
    }
}