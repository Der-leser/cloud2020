package com.chenfx.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/4/19 0019.
 */
@Component
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "哈";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int a = 1/0;
        int timeNumber = 0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" + "哈";
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "调用支付接口超时或者异常： \t" + "\t当前线程名字" + Thread.currentThread().getName();
    }


}
