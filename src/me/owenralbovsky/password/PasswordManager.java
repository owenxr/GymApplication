package me.owenralbovsky.password;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import me.owenralbovsky.users.Person;

public class PasswordManager {

	public static boolean checkPassword(Person p, String password)
	{
		if(equals(hashPassword(password), p.getPassword())) return true;
		
		return false;
	}
	
	public static byte[] hashPassword(String password)
	{
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), "$/nJ!".getBytes(), 10000, 512);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static boolean equals(byte[] pass1, byte[] pass2)
	{
		if(pass1.length != pass2.length) return false;
		
		for(int i = 0; i < pass1.length; i++) {
			if(pass1[i] != pass2[i]) return false;
		}
		
		return true;
	}
	
	public static class pm extends PasswordManager{}
	
}
