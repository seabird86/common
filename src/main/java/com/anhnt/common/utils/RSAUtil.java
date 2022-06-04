package com.anhnt.common.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    public static PublicKey toPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, NoSuchProviderException {
        byte[] keyBytes = toPemObject(key).getContent();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA", "BC").generatePublic(keySpec);
    }

    public static PrivateKey toPrivateKey(String key) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        byte[] keyBytes = toPemObject(key).getContent();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA", "BC").generatePrivate(keySpec);
    }

    public static String decrypt(String text, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // (1024, 2048)
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = Base64.getDecoder().decode(text);
        byte[] decryptedText = cipher.doFinal(bytes);
        return new String(decryptedText, StandardCharsets.UTF_8);
    }

    public static String encrypt(String text, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // (1024, 2048)
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedText = cipher.doFinal(bytes);
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    public static String sign(String content, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initSign(privateKey);
        instance.update(content.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(instance.sign());
    }

    public static boolean verify(String content, String signatureBase64, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initVerify(publicKey);
        instance.update(content.getBytes(StandardCharsets.UTF_8));
        return instance.verify(Base64.getDecoder().decode(signatureBase64));
    }

    private static PemObject toPemObject(String input) throws IOException {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
        try (PemReader reader = new PemReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))))) {
            return reader.readPemObject();
        }
    }
    public int a;
    public boolean b;
    public String c;
    public static void main(String args[]){

        System.out.println(new RSAUtil().c);
    }
    public void print() {
        int num;
        num = 1;
        System.out.println("The number is : " + num);
    }
}
