package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;

    LocalDate dataNascimento;

    private Endereco endereco; //1 pessoa tem 1 endereço
    private ArrayList<Contato> contato; //1 pessoa tem 0 ou M contatos

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = new ArrayList<Contato>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Contato> getContato() {
        return contato;
    }

    public void adicionarContato(Contato contato_obj) {
        this.contato.add(contato_obj);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco=" + endereco +
                ", contato=" + contato +
                '}';
    }
}
