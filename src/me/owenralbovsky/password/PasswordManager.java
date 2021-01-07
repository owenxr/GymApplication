package me.owenralbovsky.password;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import me.owenralbovsky.users.Person;

public class PasswordManager {

	/**
	 * @param p for the Person to check the password for
	 * @param password for the inputed password
	 * @return Whether the inputed password is valid for the Person
	 */
	public static boolean checkPassword(Person p, String password)
	{
		if(equals(hashPassword(password), p.getPassword())) return true;
		
		return false;
	}
	
	/**
	 * @param password for the password to be hashed
	 * @return the hashed Password
	 */
	public static byte[] hashPassword(String password)
	{
		try {
			//Taken from https://gist.github.com/jtan189/3804290 pbkdf2 method
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), "$/nJ!".getBytes(), 10000, 512);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param pass1 for password 1
	 * @param pass2 for password 2
	 * @return whether the two passwords are equal.
	 */
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
