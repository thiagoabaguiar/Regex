package classes;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidaSenha {

    public static void main(String[] args) {

        String senha;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite a senha para verificar a força:");
            senha = scanner.nextLine();
        }

        String resultado = verificarForcaSenha(senha);
        System.out.println(resultado);
    }

    public static String verificarForcaSenha(String senha) {

        int comprimentoMinimo = 8;

        boolean temLetraMaiuscula = Pattern.compile("[A-Z]").matcher(senha).find();
        boolean temLetraMinuscula = Pattern.compile("[a-z]").matcher(senha).find();
        boolean temNumero = Pattern.compile("\\d").matcher(senha).find();
        boolean temCaractereEspecial = Pattern.compile("\\W").matcher(senha).find();
        boolean temSequenciaComum = senha.matches(".*(?i)123456.*|.*(?i)abcdef.*");
        boolean temPalavraComum = senha.equalsIgnoreCase("password") || senha.equalsIgnoreCase("123456") || senha.equalsIgnoreCase("qwerty");

        if (senha.length() < comprimentoMinimo) {
            
            return "Senha muito curta!";
            
        } else if (temLetraMaiuscula && temLetraMinuscula && temNumero && temCaractereEspecial && !temSequenciaComum && !temPalavraComum) {
            
            return "Parabéns! Sua senha é segura";
            
        }

        return "Senha não atende aos requisitos de complexidade";
    }
}
