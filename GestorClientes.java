import java.util.Scanner;

public class GestorClientes extends Gestor<Cliente> {

    @Override
    protected Cliente criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        return new Cliente(nome, cpf, cidade);
    }

    @Override
    protected Cliente buscarPorId(int id) {
        return entidades.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Cliente buscarPorNome(String nome) {
        return entidades.stream()
                .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Cliente cliente, Scanner scanner) {
        System.out.print("Digite o novo nome (atual: " + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        cliente.setNome(nome);

        System.out.print("Digite o novo CPF (atual: " + cliente.getCpf() + "): ");
        String cpf = scanner.nextLine();
        cliente.setCpf(cpf);

        System.out.print("Digite a nova cidade (atual: " + cliente.getCidade() + "): ");
        String cidade = scanner.nextLine();
        cliente.setCidade(cidade);
    }
}
