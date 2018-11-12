
package ru.gazpromneft_at;


import org.apache.camel.Exchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Основной класс приложения.
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application {

    /**
     * Главный вход.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
