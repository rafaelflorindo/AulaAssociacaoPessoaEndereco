package controller;

import model.Pessoa;
import model.Endereco;
import model.Contato;

import java.util.ArrayList;

public class PessoaController {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private int contadorIdPessoa = 1;
    private int contadorIdEndereco = 1;
    private int contadorIdContato = 1;

    // Cadastrar pessoa
    public void cadastrarPessoa(Pessoa p) {
        p.setId(contadorIdPessoa++);
        pessoas.add(p);
    }

    // Listar pessoas
    public ArrayList<Pessoa> listarPessoas() {
        return pessoas;
    }

    // Buscar por ID
    public Pessoa buscarPessoaPorId(int id) {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Excluir pessoa
    public boolean excluirPessoa(int id) {
        Pessoa p = buscarPessoaPorId(id);
        if (p != null) {
            pessoas.remove(p);
            return true;
        }
        return false;
    }

    // Adicionar endereço
    public void adicionarEndereco(int pessoaId, Endereco e) {
        Pessoa p = buscarPessoaPorId(pessoaId);
        if (p != null) {
            e.setId(contadorIdEndereco++);
            p.setEndereco(e);
        }
    }

    // Adicionar contato
    public void adicionarContato(int pessoaId, Contato c) {
        Pessoa p = buscarPessoaPorId(pessoaId);
        if (p != null) {
            c.setId(contadorIdContato++);
            p.adicionarContato(c);
        }
    }

    // Imprimir pessoa
    public void imprimirPessoa(Pessoa p) {
        System.out.println("ID: " + p.getId());
        System.out.println("Nome: " + p.getNome());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Data Nascimento: " + p.getDataNascimento());

        Endereco e = p.getEndereco();
        if (e != null) {
            System.out.println("Endereço: " + e.getLogradouro() + ", " + e.getNumero());
        }

        System.out.println("Contatos:");
        for (Contato c : p.getContatos()) {
            System.out.println(c.getTipo() + ": " + c.getValor());
        }
    }
}
