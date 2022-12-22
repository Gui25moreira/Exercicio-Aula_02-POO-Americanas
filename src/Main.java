import java.net.InetSocketAddress;
import java.util.Scanner;

public class Main {
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

        Cliente clientes[] = new Cliente[2];
        Conta contas[] = new Conta[2];

        clientes[0] = new Cliente("Guilherme", "07330899330", "88999335989");
        clientes[1] = new Cliente("Aylla", "7105605148", "8899313980");

        contas[0] = new Conta("12345678", clientes[0], "1020");
        contas[1] = new Conta("12347801", clientes[1], "2010");

        Scanner scan = new Scanner(System.in);

        while (clienteAtivo) {
            System.out.println();
            System.out.println("Digite o numero da sua conta");
            conta = scan.next();
            Conta contaAtiva = verificaConta(contas, conta);
            Conta contaSecundária = new Conta();

            if (conta.equals(contaAtiva.getNumConta())) {
                System.out.println("Digite a sua senha");
                senha = scan.next();
                if (verificaSenha(contas, senha)) {

                    System.out.println();
                    System.out.println("Escolha uma operação");
                    System.out.println("1 - Consultar");
                    System.out.println("2 - Sacar");
                    System.out.println("3 - Depositar");
                    System.out.println("4 - Transferir");
                    System.out.println("0 - Sair da conta");
                    System.out.printf("Operação: ");

                    escolha = scan.nextInt();

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
                            contaSecundária = verificaConta(contas, conta);
                            if (conta.equals(contaSecundária.getNumConta())) {
                                System.out.println("Digite o valor que você quer transferir:");
                                valor = scan.nextDouble();
                                if (contaAtiva.sacar(valor)) {
                                    contaSecundária.depositar(valor);
                                    System.out.println("Valor transferido com sucesso!");
                                } else {
                                    System.out.println("Valor inválido! Tente novamente");
                                }
                            }
                            break;
                        case 0:
                            clienteAtivo = false;
                            System.out.println("Você saiu da conta.");
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                }

            }

        }
    }

    public static Conta verificaConta(Conta[] array, String conta) {
        Conta x = new Conta();
        for (int i = 0; i <= array.length-1; i++) {
            if (conta.equals(array[i].getNumConta())) {
                x = array[i];
            }
        }
        return x;
    }

    public static boolean verificaSenha(Conta[] array, String conta) {
        for (int i = 0; i <= array.length-1; i++) {
            if (conta.equals(array[i].getSenha())) {
                return true;
            }
        }
        return false;
    }
}


