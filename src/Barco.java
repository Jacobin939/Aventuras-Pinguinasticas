/**
 * Esta e a classe que implementa toda a logica do Barco.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Barco#pos_x} - e a posicao X do Barco no {@link Mapa#mapa} <br>
 * {@link Barco#pos_y} - e a posicao Y do Barco no {@link Mapa#mapa} <br>
 * {@link Barco#recursos} - e os {@link Recursos} do Barco
 */
public class Barco extends Jogador {
    /** E a posicao X do {@link Barco} dentro do {@link Mapa#mapa} */
    private int pos_x;

    /** E a posicao Y do {@link Barco} dentro do {@link Mapa#mapa} */
    private int pos_y;

    /**
     * O Barco tem os seguintes recursos: <br>
     * - {@link Recursos#energia} <br>
     * - {@link Recursos#peixe} <br>
     * - {@link Recursos#morale} <br>
     * - {@link Recursos#vida_da_tripulacao} <br>
     */
    private Recursos recursos;

    /**
     * Vai construir o objeto Barco
     *
     * @param posX posicao X do Barco dentro do {@link Mapa}
     * @param posY posicao Y do Barco dentro do {@link Mapa}
     * @param recursos sao os {@link Recursos} do Barco
     *
     * O resto dos parametros servem para construir o {@link Jogador}
     * @return o objeto {@link Barco}
     */
    public Barco(int pontuacao, Missao missaoAtual, int posX, int posY, Recursos recursos) {
        super(pontuacao, missaoAtual);
        this.pos_x = posX;
        this.pos_y = posY;
        this.recursos = recursos;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }
}
