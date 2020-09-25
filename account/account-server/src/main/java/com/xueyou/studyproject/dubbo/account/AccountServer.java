package com.xueyou.studyproject.dubbo.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 账户服务
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:34 下午
 */
@SpringBootApplication
@Slf4j
public class AccountServer {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(AccountServer.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application is running!\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "Swagger注解: \thttp://" + ip + ":" + port + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

}
