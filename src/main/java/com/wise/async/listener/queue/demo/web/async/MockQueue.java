/**
 * 
 */
package com.wise.async.listener.queue.demo.web.async;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 简单模拟队列
 * @author lingyuwang
 *
 */
@Component
@Slf4j
public class MockQueue {

	private String placeOrder;

	private String completeOrder;
	
	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws Exception {
		new Thread(() -> {
			log.info("接到下单请求, " + placeOrder);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.completeOrder = placeOrder;
			log.info("下单请求处理完毕," + placeOrder);
		}).start();
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}

}
