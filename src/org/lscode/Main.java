package org.lscode;

public class Main {
    private static final int NUMOFPROBES = 15;

    public static void main(String[] args) {
        FakeMessageQueue mq = new FakeMessageQueue();

        for (int i = 0; i < NUMOFPROBES; i++){
            String messageStr = mq.next();
            String[] messageFields = messageStr.split("\\|");
            Message message;

            switch (messageFields[0]){
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

            message.process();
        }
    }

}
