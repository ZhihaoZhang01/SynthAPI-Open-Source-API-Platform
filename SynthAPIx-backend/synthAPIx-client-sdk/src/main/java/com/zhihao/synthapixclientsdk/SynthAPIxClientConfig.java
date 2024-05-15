package com.zhihao.synthapixclientsdk;

import com.zhihao.synthapixclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhihao Zhang
 * @description TODO
 * @date 2024-04-15 9:20 PM
 */

@Configuration
@ConfigurationProperties("synthapix.client")
@Data
@ComponentScan
public class SynthAPIxClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public ApiClient ApiClient(){
        ApiClient apiClient = new ApiClient(accessKey,secretKey);
        return apiClient;
    }
}
