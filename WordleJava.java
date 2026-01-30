import java.util.Scanner;

public class WordleJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavraSecreta = "CASAS"; // pode ser sorteada de uma lista
        int tentativas = 6;
        int tamanho = palavraSecreta.length();

        System.out.println("Bem-vindo ao Wordle em Java!");
        System.out.println("Você tem " + tentativas + " tentativas para adivinhar a palavra de " + tamanho + " letras.");

        for (int i = 0; i < tentativas; i++) {
            System.out.print("Tentativa " + (i+1) + ": ");
            String palpite = sc.nextLine().toUpperCase();

            if (palpite.length() != tamanho) {
                System.out.println("A palavra deve ter " + tamanho + " letras!");
                i--; // não conta tentativa inválida
                continue;
            }

            if (palpite.equals(palavraSecreta)) {
                System.out.println("🎉 Parabéns! Você acertou!");
                return;
            }

            // Verificação letra por letra
            StringBuilder resultado = new StringBuilder();
            for (int j = 0; j < tamanho; j++) {
                char letra = palpite.charAt(j);
                if (letra == palavraSecreta.charAt(j)) {
                    resultado.append("[").append(letra).append("]"); // verde
                } else if (palavraSecreta.indexOf(letra) != -1) {
                    resultado.append("(").append(letra).append(")"); // amarelo
                } else {
                    resultado.append(" ").append(letra).append(" "); // cinza
                }
            }
            System.out.println("Resultado: " + resultado);
        }

        System.out.println("Fim de jogo! A palavra era: " + palavraSecreta);
        sc.close();
    }
}
