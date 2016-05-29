package pl.namiekko.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordsHelper {
	
	private SecureRandom generator;
	
	@Autowired
    BCryptPasswordEncoder bcryptEncoder;		
	
	public PasswordsHelper() throws NoSuchAlgorithmException{
		generator = new SecureRandom();
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
