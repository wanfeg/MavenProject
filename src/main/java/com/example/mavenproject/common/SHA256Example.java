package com.example.mavenproject.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {
    public static String calculateSHA256(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        String message = "Hello world!";
        try {
            String sha256Hash = calculateSHA256(message);
            System.out.println("SHA-256 Hash: " + sha256Hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
