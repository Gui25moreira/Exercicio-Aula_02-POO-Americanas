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


}

