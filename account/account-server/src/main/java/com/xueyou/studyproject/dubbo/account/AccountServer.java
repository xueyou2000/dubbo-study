package com.xueyou.studyproject.dubbo.account;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 账户服务
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:34 下午
 */

@Slf4j
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.xueyou.studyproject.dubbo.account.dubbo")
@MapperScan("com.xueyou.studyproject.dubbo.account.mapper")
public class AccountServer {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(AccountServer.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application is running!\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "Swagger注解: \thttp://localhost" + ":" + port + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

}
