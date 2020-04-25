package cn.fxpaul.mall.oms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 48642
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.fxpaul.mall.pms.dao")
@EnableSwagger2
@RefreshScope
public class MallOmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOmsApplication.class, args);
    }

}
