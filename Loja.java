public class Loja{
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;
    
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = new Endereco("", "", "", "", "", "", "");
        this.dataFundacao = new Data(1, 1, 2000);
        this.estoqueProdutos = new Produto[maxProdutos];
    }
    
    public void imprimeProdutos() {
        System.out.println("Produtos no estoque da loja: " + nome);
        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                System.out.println(produto.toString());
            }
        }
    }
    
    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
    if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
        return false;
    }
    for (int i = 0; i < estoqueProdutos.length; i++) {
        if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nomeProduto)) {
            estoqueProdutos[i] = null;
            for (int j = i; j < estoqueProdutos.length - 1; j++) {
                estoqueProdutos[j] = estoqueProdutos[j + 1];
            }
            estoqueProdutos[estoqueProdutos.length - 1] = null;
            return true;
        }
    }
    return false;
    }   
    
    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }
    
    public void setEstoqueProdutos (Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Data getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) {
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) {
            return 'P';
        } else if (quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }

    @Override
    public String toString() {
        String produtosInfo = "";
        for (Produto produto : estoqueProdutos) {
            if (produto != null) {
                produtosInfo += produto.toString() + ", ";
            }
        }
        
        if (!produtosInfo.isEmpty()) {
            produtosInfo = produtosInfo.substring(0, produtosInfo.length() - 2);
        }
        return "Loja {" +
                "Nome da loja: '" + nome + '\'' +
                ", Quantidade de Funcionários: " + quantidadeFuncionarios +
                ", Salário Base do Funcionário: " + salarioBaseFuncionario +
                ", Endereço: " + endereco +
                ", Data da Fundação: " + dataFundacao +
                ", Estoque de Produtos: [" + produtosInfo + "]" +
                ", Gastos com Salário: " + gastosComSalario() +
                ", Tamanho da Loja: " + tamanhoDaLoja() +
                '}';
    }
}
