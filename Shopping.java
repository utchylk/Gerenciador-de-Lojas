public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;
    
    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas];
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Loja[] getLojas() {
        return lojas;
    }
    
    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }
    
    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                if (tipo.equals("Cosmético") && loja instanceof Cosmetico) {
                    contador++;
                } else if (tipo.equals("Vestuário") && loja instanceof Vestuario) {
                    contador++;
                } else if (tipo.equals("Bijuteria") && loja instanceof Bijuteria) {
                    contador++;
                } else if (tipo.equals("Alimentação") && loja instanceof Alimentacao) {
                    contador++;
                } else if (tipo.equals("Informática") && loja instanceof Informatica) {
                    contador++;
                }
            }
        }
        if (contador == 0) {
            return -1;
        }
        return contador;
    }
    
    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaComMaiorSeguro = null;
        double maiorSeguro = 0;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja; 
                if (lojaInformatica.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInformatica.getSeguroEletronicos();
                    lojaComMaiorSeguro = lojaInformatica;
                }
            }
        }
        return lojaComMaiorSeguro;
    }
    @Override
    public String toString() {
        String lojasInfo = "";
        for (Loja loja : lojas) {
            if (loja != null) {
                lojasInfo += loja.toString() + "\n";
            }
        }

        return "Shopping {" +
                "Nome: '" + nome + '\'' +
                ", Endereço: " + endereco +
                ", Lojas:\n" + lojasInfo +
                '}';
    }
}