package CartaoDeCredito;

public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = 0;
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public float getLimite() {
        return limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float consultarLimite() {
        return getLimite();
    }

    public float consultarSaldo() {
        return getSaldo();
    }

    public void realizarTransacao(float valor) {
        if (valor <= getLimite()) {
            setLimite(getLimite() - valor);
            saldo += valor;
            System.out.println("Transação realizada com sucesso: " + valor);
        } else {
            System.out.println("Você não possui saldo suficiente");
        }
    }

    public void alterarLimite(float novoLimite) {
        setLimite(novoLimite);
        System.out.println("Limite alterado para: " + novoLimite);
    }
}