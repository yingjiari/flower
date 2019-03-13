package com.nf511.flower.common;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class NoteUtil {

    public static  String createId(){
        UUID uuid = UUID.randomUUID();
        return  uuid.toString();
    }
    public  static String md5(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] input = msg.getBytes();
        byte[] output = md.digest(input);
        String result= Base64.encodeBase64String(output);
        return result;
    }
}
