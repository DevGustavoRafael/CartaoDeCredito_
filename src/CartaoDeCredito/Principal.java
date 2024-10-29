package CartaoDeCredito;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do cartão:");
        String numero = scanner.nextLine();

        System.out.println("Digite o nome do titular:");
        String nomeTitular = scanner.nextLine();

        System.out.println("Digite o CPF do titular:");
        String cpfTitular = scanner.nextLine();

        System.out.println("Digite o limite do cartão:");
        float limite = scanner.nextFloat();
        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Realizar Transação");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Saldo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da transação: ");
                    float valor = scanner.nextFloat();
                    cartao.realizarTransacao(valor);
                    break;
                case 2:
                    System.out.println("Limite disponível: " + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Saldo atual: " + cartao.consultarSaldo());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}