package com.chenfx.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2020/4/25 0025.
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        return "--------------------PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return "--------------------PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
