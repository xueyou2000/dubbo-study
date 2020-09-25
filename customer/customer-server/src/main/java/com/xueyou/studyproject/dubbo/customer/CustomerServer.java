package com.xueyou.studyproject.dubbo.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 商户服务
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 2:25 下午
 */
@Slf4j
@SpringBootApplication
public class CustomerServer {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(CustomerServer.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application is running!\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "Swagger注解: \thttp://localhost" + ":" + port + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

}
