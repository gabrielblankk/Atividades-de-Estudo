/**
 * A classe Operacao representa uma operação financeira.
 *
 * @author luiza
 */
public class Operacao {
    /** O tipo de operação financeira. */
    private String operacao;
    /** O valor envolvido na operação financeira. */
    private double valor;
    /** A data em que a operação foi realizada no formato "dd/mm/aaaa". */
    private String data;
    /**
     * O destinatário da operação, que pode ser o nome de outra conta ou
     * entidade envolvida na operação (somente para operações específicas).
     */
    private String destinatario;

    /**
     * Construtor para uma operação com destinatário.
     *
     * @param operacao     O tipo de operação.
     * @param valor        O valor da operação.
     * @param data         A data da operação.
     * @param destinatario O destinatário da operação.
     */
    public Operacao(String operacao, double valor, String data, String destinatario) {
        this.setOperacao(operacao);
        this.setValor(valor);
        this.setData(data);
        this.setDestinatario(destinatario);
    }

    /**
     * Construtor para uma operação sem destinatário.
     *
     * @param operacao O tipo de operação.
     * @param valor    O valor da operação.
     * @param data     A data da operação.
     */
    public Operacao(String operacao, double valor, String data) {
        this.setOperacao(operacao);
        this.setValor(valor);
        this.setData(data);
    }

    /**
     * Define o valor da operação.
     *
     * @param valor O valor da operação.
     */
    private void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o valor da operação.
     *
     * @return O valor da operação.
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * Define a data da operação.
     *
     * @param data A data da operação.
     */
    private void setData(String data) {
        this.data = data;
    }

    /**
     * Obtém a data da operação.
     *
     * @return A data da operação.
     */
    public String getData() {
        return this.data;
    }

    /**
     * Define o destinatário da operação.
     *
     * @param destinatario O destinatário da operação.
     */
    private void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtém o destinatário da operação.
     *
     * @return O destinatário da operação.
     */
    public String getDestinatario() {
        return this.destinatario;
    }

    /**
     * Define o tipo de operação.
     *
     * @param operacao O tipo de operação.
     */
    private void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * Obtém o tipo de operação.
     *
     * @return O tipo de operação.
     */
    public String getOperacao() {
        return this.operacao;
    }
}
