package ${package}.${artifactId};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import com.xiaojukeji.base.common.util.RestUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("${package}.${artifactId}.mapper")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("SpringBoot Start Success!");
    }

    @Bean
    @LoadBalanced
    RestUtil restOperation() {
        return new RestUtil();
    }
}
