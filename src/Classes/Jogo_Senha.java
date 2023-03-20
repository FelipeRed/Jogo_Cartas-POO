package Classes;

public class Jogo_Senha {
    private Senha senha;

    public Jogo_Senha(Senha senha) {
        this.senha = senha;
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }

    public void imprimir_regras() {
        System.out.println("Regras do jogo:");
        System.out.println(" - A senha possui 4 dígitos.");
        System.out.println(" - Os números podem repetir.");
        System.out.println(" - Números possíveis: 1, 2, 3, 4.");
        System.out.println();
    }

    private int[] get_posicoes(int palpite) {  //irá retornar um array com o valor de cada posição do palpite
        int primeira_posicao = (palpite / 1000) % 10;
        int segunda_posicao = (palpite / 100) % 10;
        int terceira_posicao = (palpite / 10) % 10;
        int quarta_posicao = palpite % 10;
        return new int[] {primeira_posicao, segunda_posicao, terceira_posicao, quarta_posicao};
    }

    public int[] analisar_palpite(int palpite) {    //irá analisar o palpite dado como parâmetro e retornar
        int[] p_senha = this.senha.get_posicoes();  //o array analise onde: analise[0] conterá quantos números o jogador
        int[] p_palpite = get_posicoes(palpite);    //acertou tanto a posição quanto o valor e analise[1] conterá
                                                    //quantos números o jogador acertou mas estão na posição errada
        int num_e_pos_certa = 0;
        int num_certos = 0;

        //laço que irá contar quantos números estão na posição certa
        for (int i = 0; i < p_palpite.length; i++) {
            if (p_palpite[i] == p_senha[i]) {
                num_e_pos_certa += 1;
                p_palpite[i] = 0;
                p_senha[i] = 0;
            }
        }

        //laço que irá contar quantos números estão certos mas na posição errada
        for (int j = 0; j < p_palpite.length; j++) {
            if (p_palpite[j] != 0) {
                for (int k = 0; k < p_palpite.length; k++) {
                    if (p_palpite[j] == p_senha[k]) {
                        num_certos += 1;
                        break;
                    }
                }
            }
        }

        return new int[] {num_e_pos_certa, num_certos};
    }
}
