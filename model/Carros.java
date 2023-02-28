package model;

public class Carros {
    String chassi;
    String nome;
    String marca;
    String tipo;
    String ano;
    int valor;
    String pagamento;

    public Carros() {}

    public Carros(String chassi, String nome, String marca, String tipo, String ano, int valor, String pagamento) {
        this.chassi = chassi;
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.ano = ano;
        this.valor = valor;
        this.pagamento = pagamento;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}
