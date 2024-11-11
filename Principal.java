import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o Scanner
        Loja loja = null;
        Produto produto = null;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Menu:");
            System.out.println("1 - Criar uma loja");
            System.out.println("2 - Criar um produto");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                loja = criarLoja(scanner);
                System.out.println("Loja criada com sucesso!");
                System.out.println(loja);
            } else if (opcao == 2) {
                produto = criarProduto(scanner);
                System.out.println("Produto criado com sucesso!");
                if (produto != null) {
                    if (produto.estaVencido(new Data(20, 10, 2023))) {
                        System.out.println("PRODUTO VENCIDO");
                    } else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }
                }
                if (loja != null) {
                    loja.insereProduto(produto); // Insere o produto na loja
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close(); // Fecha o Scanner ao final
    }
    
    public static Loja criarLoja(Scanner scanner) {
        System.out.print("Digite o nome da loja: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite a quantidade de funcionários da loja: ");
        int quantidadeFuncionarios = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o salário base do funcionário: ");
        double salarioBaseFuncionario = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Digite o nome da rua: ");
        String nomeDaRua = scanner.nextLine();
        
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();
        
        System.out.print("Digite o país: ");
        String pais = scanner.nextLine();
        
        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();
        
        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();
        
        System.out.print("Digite o complemento (se houver): ");
        String complemento = scanner.nextLine();

        Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

        System.out.print("Digite o dia da fundação (dd): ");
        int dia = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o mês da fundação (mm): ");
        int mes = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o ano da fundação (aaaa): ");
        int ano = Integer.parseInt(scanner.nextLine());
        
        Data dataDaFundacao = new Data(dia, mes, ano);

        System.out.print("Digite o número máximo de produtos: ");
        int maxProdutos = Integer.parseInt(scanner.nextLine());

        return new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataDaFundacao, maxProdutos);
    }
    
    public static Produto criarProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite o dia de vencimento (dd): ");
        int dia = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o mês de vencimento (mm): ");
        int mes = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Digite o ano de vencimento (aaaa): ");
        int ano = Integer.parseInt(scanner.nextLine());
        
        Data dataVencimento = new Data(dia, mes, ano);

        return new Produto(nome, preco, dataVencimento);
    }
}