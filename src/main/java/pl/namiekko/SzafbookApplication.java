package pl.namiekko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SzafbookApplication {

    public static String ROOT = "upload-dir";

    public static void main(String[] args) {
        SpringApplication.run(SzafbookApplication.class, args);
    }
//
//	@Bean
//	CommandLineRunner init() {
//		return (String[] args) -> {
//			new File(ROOT).mkdir();
//		};
//	}
}
