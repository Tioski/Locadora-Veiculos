public class Caminhonete extends Veiculo {
    private double capacidadeCarga;
    private boolean temTração4x4;

    public Caminhonete(String marca, String modelo, String placa, int ano, double quilometragem, double capacidadeCarga, boolean temTração4x4) {
        super(marca, modelo, placa, ano, quilometragem);
        this.capacidadeCarga = capacidadeCarga;
        this.temTração4x4 = temTração4x4;
    }

    @Override
    public String getTipo() {
        return "Caminhonete";
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public boolean isTemTração4x4() {
        return temTração4x4;
    }

    public void setTemTração4x4(boolean temTração4x4) {
        this.temTração4x4 = temTração4x4;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, capacidade=%.1f kg, 4x4=%s", super.toString(), getTipo(), capacidadeCarga, temTração4x4 ? "sim" : "não");
    }
}
