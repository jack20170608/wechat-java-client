package top.jack007.nlp.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories
public class SampleApplication{

    private static final Logger log = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(){
        JettyEmbeddedServletContainerFactory jettyContainer = new JettyEmbeddedServletContainerFactory();
        Map<String, String> settings = System.getenv();
        int port = Integer.parseInt(settings.getOrDefault("APP_PORT", "8080"));
        log.info("The APP PORT:[{}].", port);
        String appName = settings.getOrDefault("APP_NAME", "wechat");
        log.info("The APP NAME:[{}].", appName);

        jettyContainer.setPort(port);
        jettyContainer.setContextPath("/" + appName);
        return jettyContainer;
    }

}