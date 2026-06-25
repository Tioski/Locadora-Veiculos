public interface Alugavel {
    boolean isDisponivel();

    void alugar();

    void devolver(double quilometragemRodada);

    String getTipo();
}
