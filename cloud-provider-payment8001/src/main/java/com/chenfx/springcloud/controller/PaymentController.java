package com.chenfx.springcloud.controller;

import com.chenfx.springcloud.entities.CommonResult;
import com.chenfx.springcloud.entities.Payment;
import com.chenfx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        if (res > 0) {
            return new CommonResult(200,"插入成功,port:" + port,res);
        } else {
            return new CommonResult(444,"插入失败,port:" + port,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment res = paymentService.getPaymentById(id);
        if (res != null) {
            return new CommonResult(200,"成功,port:" + port,res);
        } else {
            return new CommonResult(444,"失败,port:" + port,res);
        }
    }
}
