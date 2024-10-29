package CartaoDeCredito;

public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;
    private float taxaCashback;

    public CartaoDeCredito(String numero, String nomeTitular) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.limite = 1000;
        this.saldo = 0;
        this.taxaCashback = 0;
    }

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite, float taxaCashback) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = 0;
        this.taxaCashback = taxaCashback;
    }

    public float consultarLimite() {
        return limite;
    }

    public float consultarSaldo() {
        return saldo;
    }

    public void realizarTransacao(float valor) {
        if (valor <= limite - saldo) {
            saldo += valor;
            System.out.println("Transação realizada com sucesso: " + valor);
        } else {
            System.out.println("Você não possui saldo suficiente. Saldo atual: " + saldo);
        }
    }

    public void realizarTransacao(float valor, boolean comCashback) {
        if (valor <= limite - saldo) {
            saldo += valor;
            if (comCashback) {
                float cashback = valor * taxaCashback;
                saldo -= cashback;
                System.out.println("Transação realizada com sucesso: " + valor + ". Cashback aplicado: " + cashback);
            } else {
                System.out.println("Transação realizada com sucesso: " + valor);
            }
        } else {
            System.out.println("Você não possui saldo suficiente. Saldo atual: " + saldo);
        }
    }
}
