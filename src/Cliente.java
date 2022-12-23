import java.util.Scanner;

public class Cliente {
    private String nomeTitular;
    private String cpf;
    private String contato;

    public Cliente() {
    }

    public Cliente(String nomeTitular, String cpf, String contato) {
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.contato = contato;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
