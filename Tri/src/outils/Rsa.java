package outils;

import java.math.BigInteger;

import metier.user.Utilisateur;

public class Rsa {
	private BigInteger p;
	 
	private BigInteger q;
 
	private BigInteger N;
 
	private BigInteger phi;
 
	private BigInteger e;
 
	private BigInteger d;
 
	private int bitlength = 1024;
 
	private int blocksize = 256;
	public Rsa() {
		// TODO Auto-generated constructor stub
	}
	//Encryptage
	public byte[] encrypt(byte[] message) {
		 
		return (new BigInteger(message)).modPow(e, N).toByteArray();
 
	}
	//Décryptage
	public byte[] decrypt(byte[] message) {
		 
		return (new BigInteger(message)).modPow(d, N).toByteArray();
 
	}	
	private static String bytesToString(byte[] encrypted) {
		 
		String test = "";
 
		for (byte b : encrypted) {
 
			test += Byte.toString(b);
 
		}
 
		return test;
 
	}
	
	public static boolean verifieLoginEtPassword(String login, String password){
		if(login.contains("login")){
			return true;
		} else {
			return false;
		}
	}
	
	
}
