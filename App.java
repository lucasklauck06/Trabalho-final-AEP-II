import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();
        GestorMotoristas gestorMotoristas = new GestorMotoristas();
        GestorProdutos gestorProdutos = new GestorProdutos();
        GestorViagens gestorViagens = new GestorViagens(gestorMotoristas, gestorClientes, gestorProdutos);

        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Motoristas");
            System.out.println("3. Gerenciar Produtos");
            System.out.println("4. Gerenciar Viagens");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    gerenciarEntidades(scanner, gestorClientes, "Cliente");
                    break;
                case 2:
                    gerenciarEntidades(scanner, gestorMotoristas, "Motorista");
                    break;
                case 3:
                    gerenciarEntidades(scanner, gestorProdutos, "Produto");
                    break;
                case 4:
                    gerenciarViagens(scanner, gestorViagens);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void gerenciarEntidades(Scanner scanner, Gestor<?> gestor, String tipo) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("=== Gerenciar " + tipo + " ===");
            System.out.println("1. Listar " + tipo + "s");
            System.out.println("2. Cadastrar " + tipo);
            System.out.println("3. Editar " + tipo);
            System.out.println("4. Remover " + tipo);
            System.out.println("5. Voltar");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    gestor.listar();
                    break;
                case 2:
                    gestor.cadastrar(scanner);
                    break;
                case 3:
                    gestor.editar(scanner);
                    break;
                case 4:
                    gestor.remover(scanner);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarViagens(Scanner scanner, GestorViagens gestorViagens) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("=== Gerenciar Viagens ===");
            System.out.println("1. Listar Viagens");
            System.out.println("2. Iniciar Viagem");
            System.out.println("3. Finalizar Viagem");
            System.out.println("4. Voltar");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    gestorViagens.listar();
                    break;
                case 2:
                    gestorViagens.iniciarViagem(scanner);
                    break;
                case 3:
                    gestorViagens.finalizarViagem(scanner);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
