package com.CS01.SerWise.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class passwordHash {

    public static String getSHA256SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public static passwordHashGenerate generateHashedPassword(String password) throws NoSuchAlgorithmException {
        byte[] salt = getSalt();
        String hashedPassword = getSHA256SecurePassword(password, salt);
        // HashMap<String, Object> map = new HashMap<String, Object>();
        // HashMap<String, Object> map = new HashMap<>(); // Another way doing what's
        // done in the line above
        passwordHashGenerate value = new passwordHashGenerate(hashedPassword, salt);
        return value;
    }

    public static boolean equals(String password, String hashedPassword, byte[] salt) {
        String hashedGivenPassword = getSHA256SecurePassword(password, salt);

        // Returning true if hash values are equal, if not then return false
        return hashedGivenPassword != null &&   hashedGivenPassword.equals(hashedPassword);
    }
}
