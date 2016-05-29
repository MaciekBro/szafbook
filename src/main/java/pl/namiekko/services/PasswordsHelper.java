package pl.namiekko.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordsHelper {
	
	private SecureRandom generator;
	private BCryptPasswordEncoder bcryptEncoder;		
	
	public PasswordsHelper() throws NoSuchAlgorithmException{
		generator = new SecureRandom();
		bcryptEncoder = new BCryptPasswordEncoder();
	}
	
	public String getNextPasswordSeed(){
		return String.valueOf(generator.nextInt());
	}	
	
	public String encrypt(String password){
		return bcryptEncoder.encode(password);		
	}

	public SecureRandom getGenerator() {
		return generator;
	}

	public void setGenerator(SecureRandom generator) {
		this.generator = generator;
	}

}
