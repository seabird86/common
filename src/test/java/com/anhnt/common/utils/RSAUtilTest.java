package com.anhnt.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RSAUtilTest {

    private String PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCO8gCZIZ7QXlgowYlCmmAVor2mjHMcTK9mv6DxJaRs/6ttakhmLJmHKdR66JQsgYfqyVUbpvs1ij1iHQABPWJB9M8HIl7v1lMMCp5ziUZl9+5N/ocXe/xIZzWpoj5GMgJpvVrGJ7KZ9rXFgJCRIQKXNj3ZjQGvIprXXsb424I7wIDAQAB\n-----END PUBLIC KEY-----";
    private String PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\nMIICXQIBAAKBgQCCO8gCZIZ7QXlgowYlCmmAVor2mjHMcTK9mv6DxJaRs/6ttakhmLJmHKdR66JQsgYfqyVUbpvs1ij1iHQABPWJB9M8HIl7v1lMMCp5ziUZl9+5N/ocXe/xIZzWpoj5GMgJpvVrGJ7KZ9rXFgJCRIQKXNj3ZjQGvIprXXsb424I7wIDAQABAoGABAAME668xrprHQHE5YxdUzjVSd/QmcP8WACTwr5eFZmev/0tdb+38xT8OrLvKGVfdMeP/PjsxyiI14nabkm4tPJ7Dr/RXK2httdIyLhP8kGsfyJjeA4DKi2RW1w3o+346/LKQ8k+iHQzorFmhRRXVoRS9tevm4VYz1ldcwuCb9kCQQDRZf4v/vSJOM41ztul9/1XiTbik7OMiWEMiV4gCacO6fOXcHeVBXcwPWwmhHkC5DcAaQJvf4HqMnSQkhvp+QQtAkEAnzeLpIv9vOF7LipGJAWdQODFXlpFh5y253rfNVxUP+9kTxQzzI5Mo1HDUQGamfTsM+9dCTcZfj1sad4jVXgnCwJAf2E3BoVmxk7bClqCvWylHWnoDF7jO1uawOCTdJPKn0TsHLSa2flQLvU+ZBPz9TFU0BgRFjiPlCMLS6LF/kewJQJBAJztr4qQnJiVmcbHzfhlPDidEovL5+ohUbnYRraeeT/HIZQ78k41F16GET//l7UVTdZmn8mccFkYC4pRc3wjgD8CQQCsURS7MvD5JMFq8e5aAJrxGqUjUCZmT+dq2olYx1E1xV7z77MWYKku2LQKEVb/HkhR06Ff6IUVUCxppO6vaFj9\n-----END RSA PRIVATE KEY-----";
    private String text = RandomStringUtils.random(52);

    @Test
    public void toPrivateKey__success() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        PrivateKey privateKey = RSAUtil.toPrivateKey(PRIVATE_KEY);
        assertEquals(privateKey.getAlgorithm(), "RSA");
        assertEquals(privateKey.getFormat(), "PKCS#8");
    }

    @Test
    public void  toPublicKey__success() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, NoSuchProviderException {
        Security.removeProvider("BC");
        PublicKey publicKey = RSAUtil.toPublicKey(PUBLIC_KEY);
        assertNotNull(Security.getProvider("BC"));
        assertEquals(publicKey.getAlgorithm(), "RSA");
        assertEquals(publicKey.getFormat(),"X.509");
    }

    @Test
    public void encrypt__decrypt__success() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String encryptedText = RSAUtil.encrypt(text,RSAUtil.toPrivateKey(PRIVATE_KEY));
        assertEquals(text, RSAUtil.decrypt(encryptedText,RSAUtil.toPublicKey(PUBLIC_KEY)));
        encryptedText = RSAUtil.encrypt(text,RSAUtil.toPublicKey(PUBLIC_KEY));
        assertEquals(text, RSAUtil.decrypt(encryptedText,RSAUtil.toPrivateKey(PRIVATE_KEY)));
    }

    @Test
    public void encrypt__decrypt__IllegalBlockSizeException(){
        assertThrows(IllegalBlockSizeException.class,()->{
            String text = RandomStringUtils.random(100);
            RSAUtil.encrypt(text,RSAUtil.toPrivateKey(PRIVATE_KEY));
        });
    }

    @Test
    public void sign__verify__success() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException, SignatureException, InvalidKeyException {
        assertTrue(RSAUtil.verify(text,RSAUtil.sign(text,RSAUtil.toPrivateKey(PRIVATE_KEY)),RSAUtil.toPublicKey(PUBLIC_KEY)));
    }

}
