//package cn.fxpaul.mall.gateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.util.pattern.PathPatternParser;
//
///**
// * @project: mall
// * @author: FXPaul
// * @date: 2020/4/20 18:30
// */
//@Slf4j
//@Configuration
//public class MallCorsConfig {
//
//    @Bean
//    public CorsWebFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://127.0.0.1:1000");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
//        source.registerCorsConfiguration("/**", config);
//        return new CorsWebFilter(source);
//    }
//}
