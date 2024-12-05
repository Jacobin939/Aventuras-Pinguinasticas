public class Main {
    public static void main(String[] args) {
        Ilha[] ilhas = null;
        // TODO: Isto aqui passa a frente e nao esta a funcionar corretamente
        try {
            ilhas = Ilha.criarIlhas(9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.exit(1);
        }

        Jogador jogador = new Jogador(-100, null);

        Recursos recursos = new Recursos(0,0,0,0);

        Barco barco = new Barco(jogador.getPontuacao(), jogador.getMissao_atual(), 0,0, recursos);

        Mapa mapa = new Mapa(barco, ilhas);

        Jogo jogo = new Jogo(jogador, mapa);

        jogo.iniciar();
    }
}