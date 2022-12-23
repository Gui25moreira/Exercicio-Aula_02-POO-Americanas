import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

       /* Sistema Bancário
                - Deposito
                - Sacar
                - Transferir

                - Transferir apenas se tiver saldo

                - Sacar apenas se tiver saldo

                - Todos os atributos tem que ser privados
        */

        int escolha;
        double valor = 0;
        String conta = "";
        String senha = "";
        boolean clienteAtivo = true;
        boolean contaAtivada = true;
        int qtdContas = 0;

        Cliente clientes[] = new Cliente[100];
        Conta contas[] = new Conta[100];

        while (clienteAtivo) {

            imprimeMenuInicial();
            escolha = scan.nextInt();

            switch (escolha) {

                case 1:
                    System.out.println();
                    System.out.println("Digite o numero da sua conta");
                    conta = scan.next();
                    Conta contaAtiva = Conta.verificaConta(contas, conta);


                    if (conta.equals(contaAtiva.getNumConta())) {
                        System.out.println("Digite a sua senha");
                        senha = scan.next();
                        if (Conta.verificaSenha(contas, senha)) {
                            while(contaAtivada){
                            imprimeMenuSecundario();
                            escolha = scan.nextInt();
                            contaAtivada = isClienteAtivo(escolha, clienteAtivo, contas, contaAtiva);
                        }}
                    }break;

                case 2:
                    contas[qtdContas] = cadastrarConta(qtdContas, clientes);
                    qtdContas++;
                    break;
                case 0:
                    clienteAtivo = false;
                    System.out.println("Você saiu do sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private static boolean isClienteAtivo(int escolha, boolean contaAtivada, Conta[] contas, Conta contaAtiva) {
        double valor;
        String conta;
        Conta contaSecundaria;
        switch (escolha) {
            case 1:
                System.out.println("Seu saldo é de: " + contaAtiva.getSaldo());
                break;
            case 2:
                System.out.println("Digite o valor que você quer sacar:");
                valor = scan.nextDouble();
                if (contaAtiva.sacar(valor)) {
                    System.out.println("Seu saldo agora é: " + contaAtiva.getSaldo());
                } else {
                    System.out.println("Valor inválido! Tente novamente");
                    break;
                }
                break;
            case 3:
                System.out.println("Digite o valor que você quer depositar:");
                valor = scan.nextDouble();
                if (contaAtiva.depositar(valor)) {
                    System.out.println("Seu saldo agora é: " + contaAtiva.getSaldo());
                } else {
                    System.out.println("Valor inválido! Tente novamente");
                    break;
                }

            case 4:
                System.out.println("Digite a conta para qual você quer transferir:");
                conta = scan.next();
                contaSecundaria = Conta.verificaConta(contas, conta);
                if (conta.equals(contaSecundaria.getNumConta())) {
                    System.out.println("Digite o valor que você quer transferir:");
                    valor = scan.nextDouble();
                    if (contaAtiva.sacar(valor)) {
                        contaSecundaria.depositar(valor);
                        System.out.println("Valor transferido com sucesso!");
                    } else {
                        System.out.println("Valor inválido! Tente novamente");
                    }
                }
                break;
            case 0:
                contaAtivada = false;
                System.out.println("Você saiu da conta.");
                break;
            default:
                System.out.println("Opção inválida");
        }
        return contaAtivada;
    }


    public static void imprimeMenuInicial() {
        System.out.println();
        System.out.println("Escolha uma operação");
        System.out.println("1 - Acessar conta:");
        System.out.println("2 - Cadastrar Conta:");
        System.out.println("0 - Sair do sistema:");
        System.out.printf("Operação: ");
    }

    public static void imprimeMenuSecundario() {
        System.out.println();
        System.out.println("Escolha uma operação");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("0 - Sair da conta");
        System.out.printf("Operação: ");
    }

    public static Conta cadastrarConta(int qtdContas, Cliente array[]) {

        System.out.println("Digite o nome do titular:");
        String nomeTitular = scan.next();
        System.out.println("Digite o cpf do titular:");
        String cpf = scan.next();
        System.out.println("Digite o contato do titular");
        String contato = scan.next();
        System.out.println("Digite a sua senha:");
        String senha = scan.next();
        String numConta = String.valueOf((int) (Math.random() * 7020) + 1);
        System.out.println("Conta cadastrada com sucesso:");
        System.out.println("O numero da sua conta é -> " + numConta);
        Cliente cliente = new Cliente(nomeTitular, cpf, contato);
        Conta conta = new Conta(numConta, cliente, senha);
        array[qtdContas] = cliente;
        return conta;
    }
}


