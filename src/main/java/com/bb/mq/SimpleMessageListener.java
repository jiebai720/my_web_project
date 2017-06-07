package com.bb.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by admin on 2017/6/7.
 */
public class SimpleMessageListener implements MessageListener {


    private static Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message ;
        try {
            logger.info("consume message :" + msg.getText() );
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
