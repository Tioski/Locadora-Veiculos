import java.time.LocalDate;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private boolean ativa;
    private double quilometragemRodada;

    public Locacao(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = LocalDate.now();
        this.ativa = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public double getQuilometragemRodada() {
        return quilometragemRodada;
    }

    public void registrarDevolucao(double quilometragemRodada) {
        if (!ativa) {
            throw new IllegalStateException("Locação já foi encerrada.");
        }
        veiculo.devolver(quilometragemRodada);
        this.quilometragemRodada = quilometragemRodada;
        this.dataDevolucao = LocalDate.now();
        this.ativa = false;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | Veículo: %s | Data aluguel: %s | Status: %s%s",
                cliente.getNome(), veiculo.toString(), dataLocacao,
                ativa ? "ATIVA" : "FINALIZADA",
                ativa ? "" : String.format(" | Data devolução: %s | km rodada: %.1f", dataDevolucao, quilometragemRodada));
    }
}
