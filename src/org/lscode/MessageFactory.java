package org.lscode;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {

    interface MsgProducer{
        Message produceMsg(String[] messageFields);
    }

    public Message getMessage(String[] messageFields){
        Message message;

        Map<String, MsgProducer> factoryMap = new HashMap<>();

        factoryMap.put("AST", new MsgProducer(){ public Message produceMsg(String[] messageFields){ return getASTMessage(messageFields);}} );
        factoryMap.put("ASL", new MsgProducer(){ public Message produceMsg(String[] messageFields){ return getASLMessage(messageFields);}} );
        factoryMap.put("AMG", new MsgProducer(){ public Message produceMsg(String[] messageFields){ return getAMGMessage(messageFields);}} );
        factoryMap.put("OMG", new MsgProducer(){ public Message produceMsg(String[] messageFields){ return getOMGMessage(messageFields);}} );

        if (factoryMap.containsKey(messageFields[Message.MsgFld.HEADER.ordinal()])){
            return factoryMap.get(messageFields[Message.MsgFld.HEADER.ordinal()]).produceMsg(messageFields);
        }
        else{
            return getDefMessage(messageFields);
        }

    }

    private Message getASTMessage(String[] messageFields){
        return new ASTMessage(messageFields);
    }

    private Message getASLMessage(String[] messageFields){
        return new ASLMessage(messageFields);
    }

    private Message getAMGMessage(String[] messageFields){
        return new AMGMessage(messageFields);
    }

    private Message getOMGMessage(String[] messageFields){
        return new OMGMessage(messageFields);
    }

    private Message getDefMessage(String[] messageFields){
        return new DefMessage(messageFields);
    }

}
