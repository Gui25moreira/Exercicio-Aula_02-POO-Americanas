import java.util.Scanner;

public class Conta {

    private String numConta;
    private Cliente titular;
    private double saldo;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public Conta() {
    }

    public Conta(String numConta, Cliente titular, String senha) {
        this.numConta = numConta;
        this.titular = titular;
        this.senha = senha;
        this.saldo = 1000;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getNumConta() {
        return numConta;
    }


    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {

        if (valor >= 0) {
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (this.saldo >= 0) {
            if (valor >= 0 && valor <= this.saldo) {
                this.saldo -= valor;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean transferir(Conta conta1, Conta conta2, double valor) {
        if (conta1.saldo >= 0 && valor >= 0 && valor <= this.saldo) {
            conta1.saldo -= valor;
            conta2.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public static Conta verificaConta(Conta[] array, String conta) {
        Conta x = new Conta();
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != null) {
                if (conta.equals(array[i].getNumConta())) {
                    x = array[i];
                }
            }
        }
        return x;
    }

    public static boolean verificaSenha(Conta[] array, String conta) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != null) {
                if (conta.equals(array[i].getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }
}

