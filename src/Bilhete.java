import java.util.Random;

public class Bilhete {
    static final double TARIFA = 5.20;
    long numero;
    double saldo;
    Usuario usuario;

    public Bilhete(Usuario usuario) {
        numero = gerarNumero();
        this.usuario = usuario;
    }

    public long gerarNumero() {
        Random random = new Random();
        return random.nextLong(1000, 10000);
    }

    // método para carregar o bilhete
    public void carregar(double valor) {
        saldo += valor;
    }

    // método para consultar o saldo do bilhete
    public double consultarSaldo() {
        return saldo;
    }

    // método para passar na catraca
    public String passarNaCatraca() {
        double debito = TARIFA / 2;
        if(usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFA;
        }
        if(saldo >= debito) {
            saldo -= debito;
            return "Catraca liberada";
        }
        return "Sem saldo";
    }

}
