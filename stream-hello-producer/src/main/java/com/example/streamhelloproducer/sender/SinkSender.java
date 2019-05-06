package com.example.streamhelloproducer.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBinding(Processor.class)
public class SinkSender {

    private static final Logger logger = LoggerFactory.getLogger(SinkSender.class);

    @Autowired
    private Source source;


    public void sendMsg(String msg){
        source.output().send(MessageBuilder.withPayload(msg).build());
    }

    @Bean
    @InboundChannelAdapter(value= Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){

        return () -> new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = Processor.OUTPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Date message){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }


    @StreamListener(Processor.INPUT)
    public void receiveFromOutPut(Object payload){
        logger.info("Received:" +payload);
    }

//    public interface SinkOutput{
//
//        String OUTPUT = "input";
//
//        @Output(SinkOutput.OUTPUT)
//        MessageChannel output();
//    }
}

