package com.zhihao.synthapixinterface;


import com.zhihao.synthapixclientsdk.model.User;
import com.zhihao.synthapixclientsdk.client.ApiClient;

/**
 * @author Zhihao Zhang
 * @description TODO
 * @date 2024-04-14 9:39 PM
 */
public class Main {
    public static void main(String[] args) {
        String accessKey =  "ak123456";
        String secretKey =  "sk123456";
        ApiClient apiClient = new ApiClient(accessKey,secretKey);
        User user =new User();
        user.setUsername("json zhihao");
        apiClient.getNameByGet("zhihao");
        apiClient.getNameByPost("post zhihao");
        apiClient.getUsernameByPost(user);
    }
}
