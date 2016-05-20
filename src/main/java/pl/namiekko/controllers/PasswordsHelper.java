package pl.namiekko.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordsHelper {
	
	private SecureRandom generator;
	
	//@Value("#{pl.namiekko.encryption.algorithm}")
	private String encryptionAlgorithm = "PBEWithMD5AndDES";
	
	public PasswordsHelper() throws NoSuchAlgorithmException{
		generator = new SecureRandom();
	}
	
	public String getNextPasswordSeed(){
		return String.valueOf(generator.nextInt());
	}	
	
	public String encrypt(String password){
		SecretKey secretKey = new SecretKeySpec(password.getBytes(), encryptionAlgorithm);
		return secretKey.getEncoded().toString();
	}

	public SecureRandom getGenerator() {
		return generator;
	}

	public void setGenerator(SecureRandom generator) {
		this.generator = generator;
	}

	public String getEncryptionAlgorithm() {
		return encryptionAlgorithm;
	}

	public void setEncryptionAlgorithm(String encryptionAlgorithm) {
		this.encryptionAlgorithm = encryptionAlgorithm;
	} 
	
	

}
