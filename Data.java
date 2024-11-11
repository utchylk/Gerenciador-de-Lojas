public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! A data será alterada para 01/01/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }
        
        public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (isDataValida(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido! Mantendo o valor atual.");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (isDataValida(this.dia, mes, this.ano)) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido! Mantendo o valor atual.");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (isDataValida(this.dia, this.mes, ano)) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido! Mantendo o valor atual.");
        }
    }
    
    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    private boolean isDataValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        if (mes == 2 && verificaAnoBissexto()) {
            diasPorMes[1] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}