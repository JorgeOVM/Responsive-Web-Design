import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada del usuario
        System.out.print("Introduce la cadena de texto: ");
        String input = scanner.nextLine();

        // Llamar al método StringChallenge
        String transformed = StringChallenge(input);

        // Imprimir la cadena transformada
        System.out.println("Cadena transformada: " + transformed);

        // Imprimir el resultado final después de eliminar caracteres específicos
        String finalResult = removeCharacters(transformed);
        System.out.println("Resultado final: " + finalResult);

        scanner.close();
    }

    public static String StringChallenge(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder transformed = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                // Si es 'z' o 'Z', volver al inicio del alfabeto
                if (c == 'z') {
                    transformed.append('a');
                } else if (c == 'Z') {
                    transformed.append('A');
                } else {
                    transformed.append((char) (c + 1)); // Avanzar al siguiente carácter
                }
            } else {
                transformed.append(c); // Mantener caracteres no alfabéticos
            }
        }

        // Convertir las vocales a mayúsculas
        StringBuilder finalResult = new StringBuilder();
        for (char c : transformed.toString().toCharArray()) {
            switch (c) {
                case 'a': finalResult.append('A'); break;
                case 'e': finalResult.append('E'); break;
                case 'i': finalResult.append('I'); break;
                case 'o': finalResult.append('O'); break;
                case 'u': finalResult.append('U'); break;
                default: finalResult.append(c); break;
            }
        }

        return finalResult.toString();
    }

    public static String removeCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        String charsToRemove = "rtszune307";
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            // Si el carácter no está en la lista de charsToRemove, añadirlo al resultado
            if (charsToRemove.indexOf(Character.toLowerCase(c)) == -1) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
