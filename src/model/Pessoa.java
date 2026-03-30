package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;

    private LocalDate dataNascimento;

    private Endereco endereco; //1 pessoa tem 1 endereço
    private ArrayList<Contato> contatos; //1 pessoa tem 0 ou M contatos

    public Pessoa(int id, String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contatos = new ArrayList<Contato>();

//[********* IMPLEMENTAÇÃO DA BIDIRECIONAL ********* ]
        endereco.setPessoa(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

//[********* IMPLEMENTAÇÃO DA BIDIRECIONAL ********* ]
        if (endereco.getPessoa() != this) {
            endereco.setPessoa(this);
        }
    }

    public ArrayList<Contato> getContato() {
        return contatos;
    }

    public void adicionarContato(Contato contato_obj) {
        this.contatos.add(contato_obj);

//[********* IMPLEMENTAÇÃO DA BIDIRECIONAL ********* ]
       if (contato_obj.getPessoa() != this) {
            contato_obj.setPessoa(this);
        }
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "ID ='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco=" + endereco +
                ", contato=" + contatos +
                '}';
    }
}
