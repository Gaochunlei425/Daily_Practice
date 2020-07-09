package com.example.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.producer.servers.Produc;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //想拿到provide的票
    @Reference
    Produc produc;

    public void hello() {
        String ticket = produc.getTicker();
        System.out.println("买到飘了"  + ticket);
    }
}
