package pl.namiekko.controllers;

import java.io.FileNotFoundException;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.embedded.tomcat.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class SecureTomcatConfiguration {
	
	@Bean
	@Autowired
	public EmbeddedServletContainerFactory servletContainer(@Value("${tomcat.keystore.password}") String keystorePassword) throws FileNotFoundException {
		TomcatEmbeddedServletContainerFactory f = new TomcatEmbeddedServletContainerFactory();
		f.addAdditionalTomcatConnectors(createSslConnector(keystorePassword));
		return f;
	}
		
	private Connector createSslConnector(String keystorePassword) throws FileNotFoundException {
		Connector connector = new Connector(Http11NioProtocol.class.getName());
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		connector.setPort(8443);
		connector.setSecure(true);
		connector.setScheme("https");
		protocol.setSSLEnabled(true);
		protocol.setKeyAlias("szafbook");
		protocol.setKeystorePass(keystorePassword);
		protocol.setKeystoreFile(ResourceUtils.getFile("src/main/resources/tomcat.keystore").getAbsolutePath());
		protocol.setSslProtocol("TLS");
		return connector;
	}
}
