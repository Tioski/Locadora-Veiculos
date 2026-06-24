public class Moto extends Veiculo {
    private int cilindradas;
    private boolean temBau;

    public Moto(String marca, String modelo, String placa, int ano, double quilometragem, int cilindradas, boolean temBau) {
        super(marca, modelo, placa, ano, quilometragem);
        this.cilindradas = cilindradas;
        this.temBau = temBau;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public boolean isTemBau() {
        return temBau;
    }

    public void setTemBau(boolean temBau) {
        this.temBau = temBau;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %d cc, bau=%s", super.toString(), getTipo(), cilindradas, temBau ? "sim" : "não");
    }
}
