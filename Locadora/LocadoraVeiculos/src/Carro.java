public class Carro extends Veiculo {
    private int portas;
    private boolean arCondicionado;

    public Carro(String marca, String modelo, String placa, int ano, double quilometragem, int portas, boolean arCondicionado) {
        super(marca, modelo, placa, ano, quilometragem);
        this.portas = portas;
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %d portas, arCondicionado=%s", super.toString(), getTipo(), portas, arCondicionado ? "sim" : "não");
    }
}
