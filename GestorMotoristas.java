import java.util.Scanner;

public class GestorMotoristas extends Gestor<Motorista> {

    @Override
    protected Motorista criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a CNH: ");
        String cnh = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        return new Motorista(nome, cpf, cnh, cidade);
    }

    @Override
    protected Motorista buscarPorId(int id) {
        return entidades.stream()
                .filter(motorista -> motorista.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Motorista buscarPorNome(String nome) {
        return entidades.stream()
                .filter(motorista -> motorista.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void atualizarEntidade(Motorista motorista, Scanner scanner) {
        System.out.print("Digite o novo nome (atual: " + motorista.getNome() + "): ");
        String nome = scanner.nextLine();
        motorista.setNome(nome);

        System.out.print("Digite o novo CPF (atual: " + motorista.getCpf() + "): ");
        String cpf = scanner.nextLine();
        motorista.setCpf(cpf);

        System.out.print("Digite a nova CNH (atual: " + motorista.getCnh() + "): ");
        String cnh = scanner.nextLine();
        motorista.setCnh(cnh);

        System.out.print("Digite a nova cidade (atual: " + motorista.getCidade() + "): ");
        String cidade = scanner.nextLine();
        motorista.setCidade(cidade);
    }
}
