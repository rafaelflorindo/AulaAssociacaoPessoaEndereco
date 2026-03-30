//https://dontpad.com/APS-2025

import model.Contato;
import model.Endereco;
import model.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    static Scanner sc = new Scanner(System.in);

//[******************** DECLARAÇÃO DO ID COMO STATIC *****************]
    static int id = 0;
//[*******************************************************************************]

    public static void main(String[] args) {

        int op;
        System.out.println("================================================");
        System.out.println("============== CADASTRAR PESSOA ================");
        System.out.println("================================================");
        do {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Excluir por posição");
            System.out.println("4 - Excluir por código");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção do menu");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Saindo do Sistema!!!");
                    break;
                case 1:
                    //adicionar pessoa
                    System.out.println("Entre com todos os dados da pessoa:");
                    //leitura dos dados o objeto de Pessoa
                    System.out.print("Nome:");
                    String nome = sc.nextLine();

                    System.out.print("CPF:");
                    String cpf = sc.nextLine();

                    LocalDate dataNascimento = null;
                    DateTimeFormatter dataFormatada = DateTimeFormatter.ISO_LOCAL_DATE;

                    while (dataNascimento == null) {
                        System.out.print("Data de Nascimento (AAAA-MM-DD) - Ex: 1980-10-25:");
                        String dataString = sc.nextLine();

                        try {
                            dataNascimento = LocalDate.parse(dataString, dataFormatada);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato da data inválido! Digite novamente.");
                        }
                    }

                    //leitura dos dados o objeto de endereço da Pessoa
                    System.out.println("Dados do endereço: "); //Rua, Avenida, Praça, Alameda,
                    System.out.println("Informe o número correspondente: ");
                    System.out.println("1 - Alameda \n2 - Avenida \n3 - Rua");
                    int ntipo = sc.nextInt();
                    String tipoEndereco = "";

                    switch (ntipo) {
                        case 1:
                            tipoEndereco = "Alameda";
                            break;
                        case 2:
                            tipoEndereco = "Avenida";
                            break;
                        case 3:
                            tipoEndereco = "Rua";
                            break;
                        default:
                            System.out.println("Tipo de Endereço incompatível: Padrão Outros:");
                            tipoEndereco = "Outros";
                    }
                    sc.nextLine();
                    System.out.println("Nome da " + tipoEndereco + ": ");
                    String valor = sc.nextLine();

                    System.out.println("Número: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Bairro: ");
                    String bairro = sc.nextLine();

                    System.out.println("Cidade: ");
                    String cidade = sc.nextLine();

                    System.out.println("UF: ");
                    String uf = sc.nextLine();

                    System.out.println("CEP: ");
                    String CEP = sc.nextLine();

//[******************* INCLUSÃO DO CAMPO ID COM INCREMENTO *************************************** ]
                    id++;
                    Endereco endereco = new Endereco(tipoEndereco, valor, numero, bairro, CEP, cidade, uf);
                    Pessoa pessoa = new Pessoa(id, nome, cpf, dataNascimento, endereco);
//[*******************************************************************************]

                    pessoas.add(pessoa);

                    boolean adicionarContato = true;

                    while (adicionarContato) {
                        System.out.println("Tipo do contato: Entre com o número correspondente");
                        System.out.println("1 - Celular \n2 - E-mail \n3 - Linkedin");
                        int tContato = sc.nextInt();

                        String tipo = "";

                        switch (tContato) {
                            case 1:
                                tipo = "Celular";
                                break;
                            case 2:
                                tipo = "E-mail";
                                break;
                            case 3:
                                tipo = "Linkedin";
                                break;
                            default:
                                System.out.println("Tipo Contato Inválido: Padrão Outros");
                                tipo = "Outros";
                        }
                        sc.nextLine();
                        System.out.println("Valor do " + tipo + "");
                        String valorContato = sc.nextLine();
                        Contato contato = new Contato(tipo, valorContato);

                        pessoa.adicionarContato(contato);

                        System.out.println("Deseja cadastrar outro contato (S/N)? ");
                        String resposta = sc.nextLine().trim().toUpperCase();

                        if (!resposta.equals("S")) {
                            adicionarContato = false;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println(i + " - ");
                        System.out.println(pessoas.get(i));
                    }
                    break;
                case 3:
                    //excluir pessoa
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println("Posição: " + i + " - ");
                        System.out.println(pessoas.get(i));
                    }
                    System.out.println("Informe a posição a ser excluída");
                    int posicao = sc.nextInt();

//[***************** CORREÇÃO DO ERRO DE REMOVE **********************]
                    if (posicao >= 0 && posicao < pessoas.size()) {
                        pessoas.remove(posicao);
                        System.out.println("Registro excluído com sucesso!!!");
                    }else{
                        System.out.println("Posição inválida");
                    }
                    break;
//[*******************************************************************************]

// [*****************IMPLEMENTAÇÃO DO REMOVE PELO ID ******************]
                case 4:

                    for (Pessoa p: pessoas){
                        System.out.println(p);
                    }
                    System.out.println("Informe o código a ser excluído");
                    int codigoExcluir = sc.nextInt();

                    for (Pessoa p: pessoas){
                       if(codigoExcluir == p.getId()) {
                           pessoas.remove(p);
                           System.out.println("Pessoa excluída com sucesso");
                           break;
                       }
                    }
                    System.out.println("Código não encontrado");
                    break;
//[*******************************************************************************]
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);
    }
}