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
    public float consultarLimite() {
        return limite;
    }
    public float consultarSaldo() {
        return saldo;
    }
    public void realizarTransacao(float valor) {
        if (valor <= limite) {
            limite -= valor;
            saldo += valor;
            System.out.println("Transação realizada com sucesso: " + valor);
        } else {
            System.out.println("Você não possui saldo suficiente");
        }
    }
}