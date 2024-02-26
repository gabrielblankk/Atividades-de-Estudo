/**
 * A classe Endereco representa um endereço com informações de país, estado, cidade, rua e número.
 *
 * @author herick
 */
public class Endereco {
     /** O nome do país onde o endereço está localizado. */
    private String pais;
    /** O estado onde o endereço está localizado. */
    private String estado;
    /** A cidade onde o endereço está localizado. */
    private String cidade;
    /** O nome da rua ou avenida do endereço. */
    private String rua;
    /** O número do edifício ou residência no endereço. */
    private int numero;
	
    /**
     * Construtor padrão do endereço com país definido como "Brasil".
     */
    public Endereco() {
        this.pais = "Brasil";
    }

    /**
     * Obtém o país do endereço.
     *
     * @return O país do endereço.
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * Define o estado do endereço.
     *
     * @param estado O estado do endereço.
     * @return true se o estado for válido (somente letras e espaços) e definido com sucesso, caso contrário, false.
     */
    public boolean setEstado(String estado) {
        if (estado.matches("[a-zA-ZáéíóúÁÉÍÓÚãÃõÕ ]*")) {
            this.estado = estado;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o estado do endereço.
     *
     * @return O estado do endereço.
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Define a cidade do endereço.
     *
     * @param cidade A cidade do endereço.
     * @return true se a cidade for válida (somente letras, espaços e caracteres especiais) e definida com sucesso, caso contrário, false.
     */
    public boolean setCidade(String cidade) {
        if (cidade.matches("[a-zA-ZáéíóúÁÉÍÓÚãÃõÕçÇ ]*")) {
            this.cidade = cidade;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém a cidade do endereço.
     *
     * @return A cidade do endereço.
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * Define a rua do endereço.
     *
     * @param rua A rua do endereço.
     * @return true se a rua for válida (letras, números, espaços e caracteres especiais) e definida com sucesso, caso contrário, false.
     */
    public boolean setRua(String rua) {
        if (rua.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚãÃõÕçÇ ]*")) {
            this.rua = rua;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém a rua do endereço.
     *
     * @return A rua do endereço.
     */
    public String getRua() {
        return this.rua;
    }

    /**
     * Define o número do endereço.
     *
     * @param numero O número do endereço.
     * @return true se o número for válido (entre 1 e 99999) e definido com sucesso, caso contrário, false.
     */
    public boolean setNumero(int numero) {
        if (numero >= 1 && numero <= 99999) {
            this.numero = numero;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o número do endereço.
     *
     * @return O número do endereço.
     */
    public int getNumero() {
        return this.numero;
    }
}
