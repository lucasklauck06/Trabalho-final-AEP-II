import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorViagens extends Gestor<Viagem> {
    private GestorMotoristas gestorMotoristas;
    private GestorClientes gestorClientes;
    private GestorProdutos gestorProdutos;

    public GestorViagens(GestorMotoristas gestorMotoristas, GestorClientes gestorClientes, GestorProdutos gestorProdutos) {
        this.gestorMotoristas = gestorMotoristas;
        this.gestorClientes = gestorClientes;
        this.gestorProdutos = gestorProdutos;
    }

    @Override
    protected Viagem criarEntidade(Scanner scanner) {
        System.out.print("Digite a descrição da viagem: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a cidade de origem: ");
        String cidadeOrigem = scanner.nextLine();

        System.out.print("Digite a cidade de destino: ");
        String cidadeDestino = scanner.nextLine();

        Motorista motorista = selecionarMotorista(scanner);
        if (motorista == null) {
            System.out.println("Operação cancelada: Nenhum motorista selecionado.");
            return null;
        }

        Cliente cliente = selecionarCliente(scanner);
        if (cliente == null) {
            System.out.println("Operação cancelada: Nenhum cliente selecionado.");
            return null;
        }

        List<Produto> produtosSelecionados = selecionarProdutos(scanner);
        if (produtosSelecionados.isEmpty()) {
            System.out.println("Operação cancelada: Nenhum produto selecionado.");
            return null;
        }

        return new Viagem(descricao, cidadeOrigem, cidadeDestino, produtosSelecionados, motorista, cliente);
    }

    private Motorista selecionarMotorista(Scanner scanner) {
        System.out.println("Selecione um motorista disponível:");
        gestorMotoristas.listar();
        System.out.print("Digite o ID do motorista: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Motorista motorista = gestorMotoristas.buscarPorId(id);
        if (motorista == null) {
            System.out.println("Motorista não encontrado.");
        }
        return motorista;
    }

    private Cliente selecionarCliente(Scanner scanner) {
        System.out.println("Selecione um cliente:");
        gestorClientes.listar();
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Cliente cliente = gestorClientes.buscarPorId(id);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        }
        return cliente;
    }

    private List<Produto> selecionarProdutos(Scanner scanner) {
        List<Produto> produtosSelecionados = new ArrayList<>();

        while (true) {
            System.out.println("Selecione um produto para adicionar à viagem:");
            gestorProdutos.listar();
            System.out.print("Digite o ID do produto (ou 0 para finalizar): ");
            int id = scanner.nextInt();
            if (id == 0) {
                break;
            }

            Produto produto = gestorProdutos.buscarPorId(id);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Digite a quantidade desejada (disponível: " + produto.getQuantidade() + "): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            if (quantidade > produto.getQuantidade()) {
                System.out.println("Quantidade insuficiente no estoque.");
            } else {
                produto.setQuantidade(produto.getQuantidade() - quantidade);

                produtosSelecionados.add(new Produto(produto.getNome(), quantidade));
                System.out.println("Produto adicionado à viagem.");
            }
        }

        return produtosSelecionados;
    }

    @Override
    protected Viagem buscarPorId(int id) {
        return entidades.stream()
                .filter(viagem -> viagem.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Viagem viagem, Scanner scanner) {
        System.out.println("Editar viagem não implementado. Utilize outras opções.");
    }

    public void iniciarViagem(Scanner scanner) {
        Viagem novaViagem = criarEntidade(scanner);
        if (novaViagem != null) {
            entidades.add(novaViagem);
            System.out.println("Viagem iniciada com sucesso!");
        } else {
            System.out.println("Falha ao iniciar viagem. Tente novamente.");
        }
    }

    
    public void finalizarViagem(Scanner scanner) {
        listar(); 
        System.out.print("Digite o ID da viagem que deseja finalizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
    
        Viagem viagem = buscarPorId(id);
        if (viagem == null) {
            System.out.println("Viagem não encontrada.");
            return;
        }
    
        if (viagem.getStatus().equalsIgnoreCase("Finalizada")) {
            System.out.println("A viagem já está finalizada.");
            return;
        }
    
        viagem.setStatus("Finalizada");
        System.out.println("Viagem finalizada com sucesso!");
    }
    

}
