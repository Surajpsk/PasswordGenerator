package Projects;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
    private static final int DEFAULT_PASSWORD_LENGTH = 12;

    public static void main(String[] args) {
        int passwordLength = DEFAULT_PASSWORD_LENGTH;
        
        if (args.length > 0) {
            try {
                passwordLength = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for password length. Using default length: " + DEFAULT_PASSWORD_LENGTH);
            }
        }

        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }
}

