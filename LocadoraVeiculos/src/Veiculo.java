public abstract class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private double quilometragem;
    private boolean disponivel;

    public Veiculo(String marca, String modelo, String placa, int ano, double quilometragem) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.disponivel = true;
    }

    public abstract String getTipo();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void alugar() {
        if (!disponivel) {
            throw new IllegalStateException("Veículo não está disponível para aluguel.");
        }
        disponivel = false;
    }

    public void devolver(double quilometragemRodada) {
        if (quilometragemRodada < 0) {
            throw new IllegalArgumentException("Quilometragem rodada não pode ser negativa.");
        }
        this.quilometragem += quilometragemRodada;
        disponivel = true;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s (%d) - %s - %.1f km - disponível=%s",
                getTipo(), marca, modelo, ano, placa, quilometragem,
                disponivel ? "sim" : "não");
    }
}

