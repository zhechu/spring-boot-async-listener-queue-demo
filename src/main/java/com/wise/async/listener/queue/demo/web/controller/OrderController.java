/**
 * 
 */
package com.wise.async.listener.queue.demo.web.controller;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.wise.async.listener.queue.demo.web.async.DeferredResultHolder;
import com.wise.async.listener.queue.demo.web.async.MockQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * 订单控制器
 * @author lingyuwang
 *
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	@RequestMapping("/deferredResult")
	public DeferredResult<String> deferredResult() throws Exception {
		log.info("主线程开始");
		
		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);
		
		return result;
	}
	
	@RequestMapping("/callable")
	public Callable<String> callable() {
		log.info("主线程开始");

		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("副线程开始");
				Thread.sleep(1000);
				log.info("副线程返回");
				return "success";
			}
		};
	}

}
