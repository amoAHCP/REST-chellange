package ch.trivadis.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ArticleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }
}
