package org.lscode;

public class MessageFactory {

    public Message getMessage(String[] messageFields){
        Message message;
        switch (messageFields[Message.MsgFld.HEADER.ordinal()]){
            case "AST":
                message = new ASTMessage(messageFields);
                break;
            case "ASL":
                message = new ASLMessage(messageFields);
                break;
            case "AMG":
                message = new AMGMessage(messageFields);
                break;
            case "OMG":
                message = new OMGMessage(messageFields);
                break;
            default:
                message = new DefMessage(messageFields);
        }

        return message;
    }
}
