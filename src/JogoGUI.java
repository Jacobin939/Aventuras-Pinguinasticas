import javax.swing.*;
import java.awt.*;

public class JogoGUI extends JFrame {

    public JogoGUI(Missao missao, Barco barco) {
        // Configurações da janela
        setTitle("Interface de Missão");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal com imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        // Painel para conter o título e os botões
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // Fundo transparente
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // Empilha componentes verticalmente

        // Adiciona título no topo
        String nome = missao.getNome();
        JLabel titleLabel = new JLabel(nome, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Define a cor do título para preto
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o título

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Fundo transparente
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Criação dos botões
        JButton option1 = new JButton("Opção 1");
        JButton option2 = new JButton("Opção 2");
        JButton option3 = new JButton("Opção 3");

        // Estilo dos botões
        JButton[] buttons = {option1, option2, option3};
        for (JButton button : buttons) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 50));
            button.setFont(new Font("Serif", Font.PLAIN, 18));
            buttonPanel.add(button);
        }

        // Adiciona o título e os botões ao painel superior
        topPanel.add(Box.createVerticalStrut(10)); // Espaço entre o topo e o título
        topPanel.add(titleLabel); // Adiciona o título
        topPanel.add(Box.createVerticalStrut(10)); // Espaço entre o título e os botões
        topPanel.add(buttonPanel); // Adiciona os botões

        // Adiciona o painel superior ao topo do fundo
        backgroundPanel.add(topPanel, BorderLayout.NORTH);

        // Painel que vai conter o texto no lado inferior esquerdo
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false); // Transparente
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Alinha ao canto esquerdo

        // Criação de um JLabel para exibir as informações
        int peixe =  barco.getRecursos().getPeixe();
        int energia = barco.getRecursos().getEnergia();
        int morale = barco.getRecursos().getMorale();
        int vida_da_tripulacao = barco.getRecursos().getVida_da_tripulacao();
        JLabel infoLabel = new JLabel(
                "<html>Energia: " + energia +
                        "<br>Peixe: " + peixe +
                        "<br>Morale: " + morale +
                        "<br>Vida da Tripulação: " + vida_da_tripulacao + "</html>"
        );
        infoLabel.setFont(new Font("Serif", Font.PLAIN, 16)); // Ajusta a fonte
        infoLabel.setOpaque(true); // Torna o fundo visível
        infoLabel.setBackground(Color.WHITE); // Define o fundo branco
        infoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Adiciona uma borda interna

        // Adiciona o JLabel ao painel inferior esquerdo
        leftPanel.add(infoLabel);

        // Adiciona o painel esquerdo ao rodapé, alinhado à esquerda
        backgroundPanel.add(leftPanel, BorderLayout.SOUTH);

        // Adiciona o painel de fundo ao JFrame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Missao missao = new Missao("olha para mim", "nada", null, null);

        Jogador jogador = new Jogador(-100, null);
        Recursos recursos = new Recursos(0,0,0,0);
        Barco barco = new Barco(jogador.getPontuacao(), jogador.getMissao_atual(), 0,0, recursos);


        SwingUtilities.invokeLater(() -> {
            new JogoGUI(missao, barco); // Substitua por lógica de inicialização
        });
    }


    // Classe personalizada para desenhar a imagem de fundo
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Carregar a imagem "ilha.jpg"
            backgroundImage = new ImageIcon(getClass().getResource("/ilha.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Desenha a imagem preenchendo o painel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
