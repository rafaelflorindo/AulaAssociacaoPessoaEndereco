package model;

public class Contato {
    public int id;
    private String tipo;
    private String valor;


//[********* IMPLEMENTAÇÃO DA BIDIRECIONAL ********* ]
    public Pessoa pessoa;

    public Contato(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}