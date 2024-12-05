import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta e a classe que implementa toda a logica do Jogador.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogador#nome} - e o nome do Jogador <br>
 * {@link Jogador#pontuacao} - e a pontuacao final do Jogador <br>
 * {@link Jogador#missao_atual} - e a {@link Missao} que o Jogador esta a fazer no momento
 */
public class Jogador {
    /** E o nome do Jogador */
    protected String nome;

    /** E a pontuacao do Jogador que vai ser armazenada em um ficheiro*/
    protected int pontuacao;

    /** E a {@link Missao} que o Jogador esta a fazer */
    protected Missao missao_atual;

    public Jogador(int pontuacao, Missao missaoAtual) {
        this.nome = nome;

// Garantir que o diretório existe antes de salvar
        File file = new File("pontuacao.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pontuacao.txt", true))) {
            // Corrigindo a formatação para garantir que não haja erro
            writer.write(String.format("%s;%d\n", getNome(), getPontuacao()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // isto fica na mesma, so muda a pontuação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;

        // Atualiza apenas a última linha do ficheiro
        File ficheiro = new File("pontuacao.txt");
        try {
            // Lê todas as linhas do ficheiro
            List<String> linhas = new ArrayList<>();
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                linhas.add(reader.nextLine());
            }
            reader.close();

            // Substitui a última linha pela nova pontuação
            if (!linhas.isEmpty()) {
                // tem de substituir a pontuação da ultima linha
                // ou seja, substituir -> $nomeJogador;$pontuacao
                linhas.set(linhas.size() - 1, String.valueOf(pontuacao));
            } else {
                linhas.add(String.valueOf(pontuacao)); // Adiciona a pontuação se o ficheiro estava vazio
            }

            // Apaga o conteúdo do ficheiro e reescreve todas as linhas
            FileWriter writer = new FileWriter(ficheiro);
            for (String l : linhas) {
                writer.write(l + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar a pontuação: " + e.getMessage());
        }
    }

    public Missao getMissao_atual() {
        return missao_atual;
    }

    public void setMissao_atual(Missao missao_atual) {
        this.missao_atual = missao_atual;
    }

    public int escolher_direcao() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while (opcao < 1 || opcao > 4) {
            System.out.println("Escolha uma direcao");
            System.out.println("1 - cima");
            System.out.println("2 - baixo");
            System.out.println("3 - esquerda");
            System.out.println("4 - direita");
            opcao = input.nextInt();
            System.out.println(opcao);
        }
        //input.close();
        return opcao;
    }
}
