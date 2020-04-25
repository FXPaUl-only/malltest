package cn.fxpaul.mall.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "cn.fxpaul.mall.wms.dao")
@EnableSwagger2
@RefreshScope
public class MallWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWmsApplication.class, args);
    }

}
