package com.example.myappmovielastup.activity.login;

import java.nio.charset.StandardCharsets;

public class Authentication {
    private static Authentication instance;

    public Authentication() {
    }

    public static Authentication getInstance() {
        if (instance == null) instance = new Authentication();
        return instance;
    }

    public String hashPass(String password) {
        String salt = generateSalt();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);

        byte[] combinedBytes = new byte[passwordBytes.length + saltBytes.length];
        System.arraycopy(passwordBytes, 0, combinedBytes, 0, passwordBytes.length);
        System.arraycopy(saltBytes, 0, combinedBytes, passwordBytes.length, saltBytes.length);

        // Thực hiện XOR từng byte
        for (int i = 0; i < combinedBytes.length; i++) {
            combinedBytes[i] ^= 0xFF; // Đảo ngược bit
        }

        return bytesToHex(combinedBytes);
    }

    public String generateSalt() {
        byte[] salt = new byte[16];
        new java.util.Random().nextBytes(salt);
        return bytesToHex(salt);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
