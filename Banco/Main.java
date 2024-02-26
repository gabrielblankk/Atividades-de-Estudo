import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * A classe Main é a classe principal do programa.
 * Ela contém o método main que inicia a execução do programa bancário.
 *
 * @author gabriel_blank
 */
public class Main {

    /**
     * O método main é o ponto de entrada do programa.
     * Ele solicita informações do cliente e permite que o cliente crie e acesse contas bancárias,
     * além de realizar diversas operações bancárias como depósitos, saques, transferências e pagamentos.
     *
     * @param args Os argumentos de linha de comando (não são usados neste programa).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        // Instancia um objeto da classe Banco para armazenar informações dos clientes e contas.
        Banco banco = new Banco();

        System.out.println("---Criar conta---");
        // Cria um objeto da classe Cliente para armazenar informações do cliente.
        Cliente cliente = new Cliente();

        boolean valid = false;
        // Solicita e valida o nome do cliente.
        while (!valid) {
            System.out.println("Digite seu nome: ");
            if (cliente.setNome(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Nome inválido.");
            }
        }

        // Solicita e valida o CPF do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite seu CPF: ");
            if (cliente.setCpf(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("CPF inválido.");
            }
        }

        // Solicita e valida o telefone do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite seu telefone: ");
            if (cliente.setTelefone(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Telefone inválido.");
            }
        }

        System.out.println("---Endereço---");

        // Cria um objeto da classe Endereco para armazenar informações do endereço do cliente.
        Endereco endereco = new Endereco();

        // Solicita e valida o estado do endereço do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite seu estado: ");
            if (endereco.setEstado(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Estado inválido.");
            }
        }

        // Solicita e valida a cidade do endereço do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite sua cidade: ");
            if (endereco.setCidade(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Cidade inválida.");
            }
        }

        // Solicita e valida a rua do endereço do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite sua rua: ");
            if (endereco.setRua(input.next())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Rua inválida.");
            }
        }

        // Solicita e valida o número do endereço do cliente.
        valid = false;
        while (!valid) {
            System.out.println("Digite seu número: ");
            if (endereco.setNumero(input.nextInt())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Número inválido.");
            }
        }

        // Associa o endereço ao cliente.
        cliente.setEndereco(endereco);

        // Adiciona o cliente ao banco.
        banco.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado!");

        // Loop principal do programa que permite ao cliente criar ou acessar contas e realizar operações bancárias.
        while (true) {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Acessar conta");

            // Lê a escolha do cliente.
            switch (input.nextInt()) {
                case 1:
                    // Cria um objeto da classe Conta associado ao cliente.
                    Conta conta = new Conta(cliente);
                    valid = false;

                    // Solicita e valida o login da conta.
                    while (!valid) {
                        System.out.println("Crie um login: ");
                        if (conta.setLogin(input.next())) {
                            valid = true;
                        } else {
                            valid = false;
                            System.out.println("Login inválido.");
                        }
                    }

                    // Solicita e valida a senha da conta.
                    valid = false;
                    while (!valid) {
                        System.out.println("Crie uma senha: ");
                        if (conta.setSenha(input.next())) {
                            valid = true;
                        } else {
                            valid = false;
                            System.out.println("Senha inválida.");
                        }
                    }

                    // Solicita e valida o tipo da conta (Corrente, Poupança ou Investimento).
                    valid = false;
                    while (!valid) {
                        System.out.println("Selecione o tipo da conta: ");
                        System.out.println("1 - Corrente");
                        System.out.println("2 - Poupança");
                        System.out.println("3 - Investimento");

                        // Lê a escolha do cliente.
                        switch (input.nextInt()) {
                            case 1:
                                conta.setTipo("Corrente");
                                valid = true;
                                break;
                            case 2:
                                conta.setTipo("Poupança");
                                valid = true;
                                break;
                            case 3:
                                conta.setTipo("Investimento");
                                valid = true;
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                                valid = false;
                                break;
                        }
                    }

                    valid = false;
                    // Solicita e valida a agência da conta.
                    while (!valid) {
                        System.out.println("Selecione a agência: ");
                        System.out.println("1 - Santander");
                        System.out.println("2 - Banco do Brasil");
                        System.out.println("3 - Bradesco");

                        // Lê a escolha do cliente.
                        switch (input.nextInt()) {
                            case 1:
                                conta.setAgencia(new Agencia(1));
                                valid = true;
                                break;
                            case 2:
                                conta.setAgencia(new Agencia(2));
                                valid = true;
                                break;
                            case 3:
                                conta.setAgencia(new Agencia(3));
                                valid = true;
                                break;
                            default:
                                System.out.println("Agência inválida.");
                                valid = false;
                                break;
                        }
                    }

                    // Adiciona a conta ao cliente.
                    cliente.adicionarConta(conta);
                    System.out.println("Conta criada!");
                    valid = true;
                    break;
                case 2:
                    // Verifica se o cliente possui contas para acessar.
                    if (cliente.getContas().size() < 1) {
                        System.out.println("Você não possui contas.");
                        continue;
                    } else {
                        valid = false;

                        // Loop para solicitar o login e senha da conta.
                        while (!valid) {
                            System.out.println("Digite seu login: ");
                            String login = input.next();
                            boolean validLogin = false;

                            // Verifica se o login é válido.
                            for (int i = 0; i < cliente.getContas().size(); i++) {
                                if (login.equals(cliente.getContas().get(i).getLogin())) {
                                    validLogin = true;
                                }
                            }

                            if (!validLogin) {
                                System.out.println("Conta não existente.");
                                valid = false;
                            } else {
                                System.out.println("Digite sua senha: ");
                                String senha = input.next();
                                boolean correctPassword = false;

                                // Verifica se a senha é correta.
                                for (int i = 0; i < cliente.getContas().size(); i++) {
                                    if (senha.equals(cliente.getContas().get(i).getSenha())) {
                                        correctPassword = true;
                                        break;
                                    }
                                }

                                if (!correctPassword) {
                                    System.out.println("Senha incorreta.");
                                    valid = false;
                                } else {
                                    valid = true;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    valid = false;
                    break;
            }

            valid = false;
            // Menu de operações bancárias.
            while (!valid) {
                System.out.println("1 - Sair");
                System.out.println("2 - Visualizar saldo");
                System.out.println("3 - Visualizar extrato de operações");
                System.out.println("4 - Realizar depósito ou saque");

                // Verifica o tipo de conta para habilitar opções adicionais.
                if (cliente.getContas().get(0).getTipo().equals("Corrente")) {
                    System.out.println("5 - Realizar transferência ou pagamento");
                }

                // Lê a escolha do cliente.
                switch (input.nextInt()) {
                    case 1:
                        valid = true;
                        break;
                    case 2:
                        // Exibe o saldo da conta.
                        System.out.println("Saldo: R$" + cliente.getContas().get(0).getSaldo());
                        break;
                    case 3:
                        // Exibe o extrato de operações da conta.
                        cliente.getContas().get(0).mostrarOperacoes();
                        break;
                    case 4:
                        boolean valid2 = false;
                        // Menu de depósito ou saque.
                        while (!valid2) {
                            System.out.println("1 - Depositar");
                            System.out.println("2 - Sacar");

                            // Lê a escolha do cliente.
                            switch (input.nextInt()) {
                                case 1:
                                    System.out.println("Qual o valor? ");
                                    double valorDeposito = input.nextDouble();
                                    // Realiza o depósito na conta.
                                    cliente.getContas().get(0).setSaldo(cliente.getContas().get(0).getSaldo() + valorDeposito);
                                    Date dataDeposito = new Date();
                                    Operacao operacaoDeposito = new Operacao("Depósito", valorDeposito, format.format(dataDeposito));
                                    cliente.getContas().get(0).adicionarOperacao(operacaoDeposito);
                                    valid2 = true;
                                    break;
                                case 2:
                                    System.out.println("Qual o valor? ");
                                    double valorSaque = input.nextDouble();
                                    // Verifica se é possível realizar o saque.
                                    if (cliente.getContas().get(0).getSaldo() < valorSaque) {
                                        System.out.println("Não é possível sacar mais do que a cliente.getContas().get(0) tem.");
                                        valid2 = false;
                                    } else {
                                        // Realiza o saque na conta.
                                        cliente.getContas().get(0).setSaldo(cliente.getContas().get(0).getSaldo() - valorSaque);
                                        Date dataSaque = new Date();
                                        Operacao operacaoSaque = new Operacao("Saque", valorSaque, format.format(dataSaque));
                                        cliente.getContas().get(0).adicionarOperacao(operacaoSaque);
                                        valid2 = true;
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                                    valid2 = false;
                                    break;
                            }
                        }
                        break;
                    case 5:
                        if (cliente.getContas().get(0).getTipo().equals("Corrente")) {
                            valid2 = false;
                            // Menu de transferência ou pagamento.
                            while (!valid2) {
                                System.out.println("1 - Pagamento");
                                System.out.println("2 - Transferência");

                                // Lê a escolha do cliente.
                                switch (input.nextInt()) {
                                    case 1:
                                        System.out.println("Qual o valor? ");
                                        double valorPagamento = input.nextDouble();
                                        System.out.println("Para quem? ");
                                        String destinatarioPagamento = input.next();

                                        Date dataPagamento = new Date();
                                        Operacao operacaoPagamento = new Operacao("Pagamento", valorPagamento, format.format(dataPagamento), destinatarioPagamento);
                                        cliente.getContas().get(0).adicionarOperacao(operacaoPagamento);
                                        // Realiza o pagamento na conta.
                                        cliente.getContas().get(0).setSaldo(cliente.getContas().get(0).getSaldo() - valorPagamento);

                                        valid2 = true;
                                        break;
                                    case 2:
                                        System.out.println("Qual o valor? ");
                                        double valorTransf = input.nextDouble();
                                        System.out.println("Para quem? ");
                                        String destinatarioTransf = input.next();

                                        Date dataTransf = new Date();
                                        Operacao operacaoTransf = new Operacao("Transferência", valorTransf, format.format(dataTransf), destinatarioTransf);
                                        cliente.getContas().get(0).adicionarOperacao(operacaoTransf);
                                        // Realiza a transferência na conta.
                                        cliente.getContas().get(0).setSaldo(cliente.getContas().get(0).getSaldo() - valorTransf);

                                        valid2 = true;
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                        valid2 = false;
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Opção inválida.");
                            valid = false;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        valid = false;
                        break;
                }
            }
        }
    }
}
