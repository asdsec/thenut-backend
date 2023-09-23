package com.attech.thenutapi;

import com.attech.thenutapi.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(
		includeFilters = {
			@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
		}
)
public class ThenutApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThenutApiApplication.class, args);
	}

}
