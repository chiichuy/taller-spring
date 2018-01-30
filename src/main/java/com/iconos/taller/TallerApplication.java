package com.iconos.taller;

import com.ens.user.userrest.UserRestClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerApplication {

//	@Bean
//	public String usuario() {
//		return "Hola mundo";
//	}

	@Bean
	UserRestClient userRestClient() {
		return Feign.builder()
				.client(new OkHttpClient())
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(UserRestClient.class, "http://localhost:7070/");
	}


	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}
}
