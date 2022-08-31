package io.nicholasjackson.fakeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FakeServiceApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
    return builder.sources(FakeServiceApplication.class);
  }

	public static void main(String[] args) {
		SpringApplication.run(FakeServiceApplication.class, args);
	}

}
