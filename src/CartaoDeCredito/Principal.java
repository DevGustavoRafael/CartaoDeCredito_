package CartaoDeCredito;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do cartão:");
        String numero = scanner.nextLine();
        System.out.println("Digite o nome do titular:");
        String nomeTitular = scanner.nextLine();

        System.out.println("Deseja cadastrar o cartão com um limite personalizado? (s/n): ");
        char resposta = scanner.next().charAt(0);

        float limite = 1000;
        float taxaCashback = 0;

        if (resposta == 's' || resposta == 'S') {
            System.out.println("Digite o limite do cartão:");
            while (true) {
                try {
                    limite = scanner.nextFloat();
                    if (limite < 0) {
                        System.out.println("O limite deve ser um valor positivo. Tente novamente.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.next();
                }
            }

            System.out.println("Digite a taxa de cashback (em decimal, por exemplo, 0.1 para 10%):");
            while (true) {
                try {
                    taxaCashback = scanner.nextFloat();
                    if (taxaCashback < 0) {
                        System.out.println("A taxa de cashback deve ser um valor positivo. Tente novamente.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.next();
                }
            }
        }

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, "", limite, taxaCashback);

        int opcao;
        do {
            opcao = exibirMenu(scanner);
            switch (opcao) {
                case 0:
                    System.out.print("Tem certeza que deseja sair? (s/n): ");
                    char confirm = scanner.next().charAt(0);
                    if (confirm != 's' && confirm != 'S') {
                        opcao = -1;
                        break;
                    }
                    System.out.println("Saindo...");
                    break;
                case 1:
                    realizarTransacao(scanner, cartao);
                    break;
                case 2:
                    System.out.println("Limite disponível: " + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Saldo atual: " + cartao.consultarSaldo());
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("\nMenu:");
        System.out.println("1. Realizar Transação");
        System.out.println("2. Consultar Limite");
        System.out.println("3. Consultar Saldo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    private static void realizarTransacao(Scanner scanner, CartaoDeCredito cartao) {
        float valor = 0;
        while (true) {
            try {
                System.out.print("Digite o valor da transação: ");
                valor = scanner.nextFloat();
                if (valor < 0) {
                    System.out.println("O valor da transação deve ser positivo. Tente novamente.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
        }

        System.out.print("Deseja aplicar cashback? (s/n): ");
        char aplicarCashback = scanner.next().charAt(0);
        if (aplicarCashback == 's' || aplicarCashback == 'S') {
            cartao.realizarTransacao(valor, true);
        } else {
            cartao.realizarTransacao(valor);
        }
    }
}
