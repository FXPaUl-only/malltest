package cn.fxpaul.mall.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author FXPaul
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.fxpaul.mall.pms.dao")
@EnableSwagger2
@RefreshScope
@EnableFeignClients
public class MallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPmsApplication.class, args);
    }

}
