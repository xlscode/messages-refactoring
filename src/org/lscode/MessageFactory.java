package org.lscode;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {

    interface MsgProducer{
        Message produceMsg(String[] messageFields);
    }

    private Map<String, MsgProducer> factoryMap = new HashMap<>();

    public MessageFactory(){
        factoryMap.put("AST", mf -> getASTMessage(mf) );
        factoryMap.put("ASL", mf -> getASLMessage(mf) );
        factoryMap.put("AMG", mf -> getAMGMessage(mf) );
        factoryMap.put("OMG", mf -> getOMGMessage(mf) );
    }

    public Message getMessage(String[] messageFields){

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
