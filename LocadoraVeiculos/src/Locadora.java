import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Locadora {
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final List<Locacao> locacoes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Locadora().executar();
    }

    private void executar() {
        inicializarVeiculos();
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarVeiculo();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 5:
                    alugarVeiculo();
                    break;
                case 6:
                    devolverVeiculo();
                    break;
                case 7:
                    listarLocacoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }

    private void exibirMenu() {
        System.out.println("===== LOCADORA =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Veículo");
        System.out.println("3 - Listar Clientes");
        System.out.println("4 - Listar Veículos");
        System.out.println("5 - Alugar Veículo");
        System.out.println("6 - Devolver Veículo");
        System.out.println("7 - Listar Locações");
        System.out.println("0 - Sair");
    }

    private void inicializarVeiculos() {
        veiculos.add(new Carro("Toyota", "Corolla", "ABC-1234", 2024, 15000.0, 4, true));
        veiculos.add(new Carro("Volkswagen", "Golf", "GHI-2345", 2021, 32000.0, 4, true));
        veiculos.add(new Carro("Honda", "Civic", "JKL-3456", 2023, 12000.0, 4, false));

        veiculos.add(new Moto("Honda", "CG 160", "XYZ-5678", 2023, 8000.0, 160, false));
        veiculos.add(new Moto("Yamaha", "Fazer 250", "MNO-4567", 2022, 9000.0, 250, true));
        veiculos.add(new Moto("Suzuki", "Gixxer", "PQR-5678", 2024, 3000.0, 150, false));

        veiculos.add(new Caminhonete("Ford", "Ranger", "DEF-9012", 2022, 25000.0, 1200.0, true));
        veiculos.add(new Caminhonete("Chevrolet", "S10", "STU-6789", 2023, 18000.0, 1000.0, false));
        veiculos.add(new Caminhonete("Toyota", "Hilux", "VWX-7890", 2024, 11000.0, 1400.0, true));
    }

    private void cadastrarCliente() {
        System.out.println("--- Cadastrar Cliente ---");
        Cliente cliente = new Cliente();
        cliente.setNome(lerTexto("Nome: "));
        cliente.setCpf(lerTexto("CPF: "));
        cliente.setEndereco(lerTexto("Endereço: "));
        cliente.setTelefone(lerTexto("Telefone: "));
        cliente.setEmail(lerTexto("Email: "));

        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void cadastrarVeiculo() {
        System.out.println("--- Cadastrar Veículo ---");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhonete");
        int tipo = lerInteiro("Tipo de veículo: ");

        String marca = lerTexto("Marca: ");
        String modelo = lerTexto("Modelo: ");
        String placa = lerTexto("Placa: ");
        int ano = lerInteiro("Ano: ");
        double quilometragem = lerDouble("Quilometragem: ");

        Veiculo veiculo;
        if (tipo == 1) {
            int portas = lerInteiro("Número de portas: ");
            boolean arCondicionado = lerBoolean("Ar condicionado (true/false): ");
            veiculo = new Carro(marca, modelo, placa, ano, quilometragem, portas, arCondicionado);
        } else if (tipo == 2) {
            int cilindradas = lerInteiro("Cilindradas: ");
            boolean temBau = lerBoolean("Tem baú (true/false): ");
            veiculo = new Moto(marca, modelo, placa, ano, quilometragem, cilindradas, temBau);
        } else if (tipo == 3) {
            double capacidadeCarga = lerDouble("Capacidade de carga (kg): ");
            boolean temTracao4x4 = lerBoolean("Tem tração 4x4 (true/false): ");
            veiculo = new Caminhonete(marca, modelo, placa, ano, quilometragem, capacidadeCarga, temTracao4x4);
        } else {
            System.out.println("Tipo inválido. Cadastro cancelado.");
            return;
        }

        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso.");
    }

    private void listarClientes() {
        System.out.println("--- Lista de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, clientes.get(i));
        }
    }

    private void listarVeiculos() {
        System.out.println("--- Lista de Veículos ---");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, veiculos.get(i));
        }
    }

    private void alugarVeiculo() {
        System.out.println("--- Alugar Veículo ---");
        if (clientes.isEmpty()) {
            System.out.println("Cadastre um cliente antes de alugar.");
            return;
        }
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                disponiveis.add(veiculo);
            }
        }
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponível para locação.");
            return;
        }

        listarClientes();
        int clienteIndex = lerInteiro("Escolha o número do cliente: ") - 1;
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }

        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, disponiveis.get(i));
        }
        int veiculoIndex = lerInteiro("Escolha o número do veículo disponível: ") - 1;
        if (veiculoIndex < 0 || veiculoIndex >= disponiveis.size()) {
            System.out.println("Veículo inválido.");
            return;
        }

        Cliente cliente = clientes.get(clienteIndex);
        Veiculo veiculo = disponiveis.get(veiculoIndex);
        veiculo.alugar();
        locacoes.add(new Locacao(cliente, veiculo));
        System.out.println("Veículo alugado com sucesso.");
    }

    private void devolverVeiculo() {
        System.out.println("--- Devolver Veículo ---");
        List<Locacao> ativas = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            if (locacao.isAtiva()) {
                ativas.add(locacao);
            }
        }
        if (ativas.isEmpty()) {
            System.out.println("Nenhuma locação ativa.");
            return;
        }

        for (int i = 0; i < ativas.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, ativas.get(i));
        }

        int locacaoIndex = lerInteiro("Escolha o número da locação: ") - 1;
        if (locacaoIndex < 0 || locacaoIndex >= ativas.size()) {
            System.out.println("Locação inválida.");
            return;
        }

        double quilometragemRodada = lerDouble("Quilometragem rodada desde o aluguel: ");
        ativas.get(locacaoIndex).registrarDevolucao(quilometragemRodada);
        System.out.println("Veículo devolvido com sucesso.");
    }

    private void listarLocacoes() {
        System.out.println("--- Lista de Locações ---");
        if (locacoes.isEmpty()) {
            System.out.println("Nenhuma locação registrada.");
            return;
        }
        for (Locacao locacao : locacoes) {
            System.out.println(locacao);
        }
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número válido.");
            }
        }
    }

    private boolean lerBoolean(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.equals("true") || entrada.equals("sim")) {
                return true;
            }
            if (entrada.equals("false") || entrada.equals("não") || entrada.equals("nao")) {
                return false;
            }
            System.out.println("Valor inválido. Digite true/false ou sim/não.");
        }
    }
}

