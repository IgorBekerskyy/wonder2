package ua.lviv.iot.springfirst.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.first.dataaccess", "ua.lviv.iot.first.business", "ua.lviv.iot.first.rest.controller"})
@EnableJpaRepositories({"ua.lviv.iot.first.dataaccess"})
public class RestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }

}