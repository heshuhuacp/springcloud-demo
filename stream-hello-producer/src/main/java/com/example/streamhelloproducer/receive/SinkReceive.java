package com.example.streamhelloproducer.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

//@EnableBinding(value={Sink.class})
//public class SinkReceive {
//
//    private static final Logger logger = LoggerFactory.getLogger(SinkReceive.class);
//
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    public void receive(Object payload){
//        logger.info("Received:"+payload);
//    }
//
//    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
//    public Object transform(Date message){
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
//    }
//}
