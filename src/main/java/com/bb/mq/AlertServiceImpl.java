package com.bb.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by bj on 2017-06-07.
 */
@Component
public class AlertServiceImpl implements AlertService {


    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations){
        this.jmsOperations = jmsOperations ;
    }


    @Override
    public void sendSpittleAlert(final Spittle spittle) {

//        jmsOperations.send("spittle.alert.queue",
//                new MessageCreator() {
//                    @Override
//                    public Message createMessage(Session session) throws JMSException {
//
//                        return session.createObjectMessage(spittle) ;
//                    }
//                });

//        jmsOperations.send(
//                new MessageCreator() {
//                    @Override
//                    public Message createMessage(Session session) throws JMSException {
//
//                        return session.createObjectMessage(spittle) ;
//                    }
//                });
        jmsOperations.convertAndSend(spittle);
    }


    public Spittle receiveSpittleAlert(){

        try {
            ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive();
            return (Spittle) receivedMessage.getObject();
        } catch (JMSException e) {
//            e.printStackTrace();
            throw JmsUtils.convertJmsAccessException(e);
        }
//        return (Spittle) jmsOperations.receiveAndConvert() ;
    }


}
