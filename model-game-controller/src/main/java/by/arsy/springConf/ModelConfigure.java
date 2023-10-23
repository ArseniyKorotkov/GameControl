package by.arsy.springConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan("by.arsy")
public class ModelConfigure {

    @Bean
    public String b() {
        return "BB";
    }
}
