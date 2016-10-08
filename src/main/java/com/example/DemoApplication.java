package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		log.info("Welcome home");
        String myEnv = env.getProperty("MY_ENV");
		return String.format("Hello World! Im on this environment: %s", myEnv);
	}

	@RequestMapping("/thomas")
	@ResponseBody
	String thomas() {
		log.info("Welcome Thomas");
		return "Hello Thomas";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
