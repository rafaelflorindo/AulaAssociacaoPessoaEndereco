package model;

public class Endereco {
    private String nome;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String UF;

    public Endereco(String nome, String logradouro, int numero, String bairro, String cep, String cidade, String UF) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.UF = UF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "nome='" + nome + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", UF='" + UF + '\'' +
                '}';
    }
}
