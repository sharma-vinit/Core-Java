/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Java.Encryption;

/**
 *
 * @author Vinit
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class JEncrytion {

    private Cipher desCipher;
    private SecretKey myDesKey;

    public JEncrytion() {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            myDesKey = keygenerator.generateKey();
            // Create the cipher
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JEncrytion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(JEncrytion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] Encryption(String data) {
        byte[] textEncrypted = null;
        try {
            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = "This is salted text".getBytes();

            System.out.println("Text [Byte Format] : " + text);
            System.out.println("Text : " + new String(text));

            // Encrypt the text
            textEncrypted = desCipher.doFinal(text);

            System.out.println("Text Encryted : " + textEncrypted);

            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Text Decryted : " + new String(textDecrypted));

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return textEncrypted;

    }

    public String Decryption(byte[] textEncrypted) {
        byte[] textDecrypted = null;
        try {
            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            textDecrypted = desCipher.doFinal(textEncrypted);
            System.out.println("Text Decryted : " + new String(textDecrypted));

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return (new String(textDecrypted));
    }
}
