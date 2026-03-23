import model.Contato;
import model.Endereco;
import model.Pessoa;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("=================== CADASTRO DE PESSOA ===================");
        System.out.println("==========================================================");

        System.out.println("\n>> Informe os dados da pessoa <<");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        //****************************************************************
        LocalDate dataNascimento = null;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        while (dataNascimento == null) {
            System.out.print("Data de nascimento (AAAA-MM-DD): ");
            String dataStr = sc.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Digite no padrão AAAA-MM-DD.");
            }
        }
        //****************************************************************
        System.out.println("Tipo de logradouro:");
        System.out.print("1 - Rua\n2 - Avenida\n3 - Travessa\n4 - Praça\n5 - Alameda\nEscolha o número correspondente: ");
        int tLogradouro = sc.nextInt();
        sc.nextLine(); // limpar buffer

        String tipoLogradouro = "";

        switch (tLogradouro) {
            case 1:
                tipoLogradouro = "Rua";
                break;
            case 2:
                tipoLogradouro = "Avenida";
                break;
            case 3:
                tipoLogradouro = "Travessa";
                break;
            case 4:
                tipoLogradouro = "Praça";
                break;
            case 5:
                tipoLogradouro = "Alameda";
                break;
            default:
                System.out.println("Opção inválida! Será definido como 'Rua' por padrão.");
                tipoLogradouro = "Rua";
                break;
        }

        System.out.print("Nome da "+tipoLogradouro+": ");
        String rua = sc.nextLine();

        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine(); // limpar buffer

        System.out.print("Bairro: ");
        String bairro = sc.nextLine();

        System.out.print("CEP: ");
        String cep = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Estado (UF): ");
        String estado = sc.nextLine();

        Endereco endereco = new Endereco(bairro, tipoLogradouro, numero, rua, cep, cidade, estado);

        Pessoa pessoa = new Pessoa(nome, cpf, dataNascimento, endereco);

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa);

        boolean adicionarMais = true;

        while (adicionarMais) {
            System.out.println("<< Informe os dados do Contato >>");
            System.out.print("Escolha um tipo de contato: \n1 - Celular \n2 - Email \n3 - Linkedin \n4 - GitHub\nEscolha o contato correspondente: ");
            int tcontato = sc.nextInt();
            sc.nextLine(); // limpar buffer

            String tipo = "";

            switch (tcontato) {
                case 1:
                    tipo = "Celular";
                    break;
                case 2:
                    tipo = "Email";
                    break;
                case 3:
                    tipo = "Linkedin";
                    break;
                case 4:
                    tipo = "GitHub";
                    break;
                default:
                    System.out.println("Opção inválida! Será definido como 'Outro'");
                    tipo = "Outro";
                    break;
            }

            System.out.print("Valor do " + tipo + ": ");
            String valor = sc.nextLine();

            Contato contato = new Contato(tipo, valor);
            pessoa.adicionarContato(contato);

            System.out.print("Deseja cadastrar outro contato? (S/N): ");
            String resposta = sc.nextLine().trim().toUpperCase();

            if (!resposta.equals("S")) {
                adicionarMais = false; // sai do loop
            }
        }

        System.out.println(pessoa);
    }
}