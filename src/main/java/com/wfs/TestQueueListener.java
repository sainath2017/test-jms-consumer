package com.wfs;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author vsrivastava
 * @since 10/2/18
 **/
@Component
public class TestQueueListener {
	

    private static final Logger LOG = LoggerFactory.getLogger(TestQueueListener.class);

    @JmsListener(destination = "land-pricing.test-queue")
    public void receive(Message message) {
        LOG.info("Begin receive message = {}", message);
        try {
            String msgStr = ((TextMessage) message).getText();
            LOG.info("Printing after casting the message = {}", msgStr);
          } catch (JMSException e) {
        	  LOG.error("Unable to read received message ", e);
          }
    }
}
