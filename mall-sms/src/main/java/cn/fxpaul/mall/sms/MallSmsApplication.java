package cn.fxpaul.mall.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author FXPaul
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.fxpaul.mall.sms.dao")
@EnableSwagger2
@RefreshScope
public class MallSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSmsApplication.class, args);
    }

}
