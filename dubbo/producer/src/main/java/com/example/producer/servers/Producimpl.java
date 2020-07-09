package com.example.producer.servers;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class Producimpl implements Produc {

    @Override
    public String getTicker() {
        return "TMD GB";
    }
}
