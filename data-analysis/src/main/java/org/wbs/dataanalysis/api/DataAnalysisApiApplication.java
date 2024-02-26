package org.wbs.dataanalysis.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wbs.dataanalysis.api.models.Measurement;
import org.wbs.dataanalysis.api.services.MeasurementService;

import java.util.List;

@RestController
@SpringBootApplication
@ComponentScan("org.wbs.dataanalysis.api")
public class DataAnalysisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAnalysisApiApplication.class, args);
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "Hello from spring boot";
	}


}
