package com.example.streamhello.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(value={Processor.class})
public class SinkReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receive(Object payload){
        logger.info("Received:"+ payload);

        return "From input Channel Return -"+ payload;
    }

}
