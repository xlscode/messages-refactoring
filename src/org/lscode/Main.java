package org.lscode;

public class Main {
    private static final int NUMOFPROBES = 15;

    public static void main(String[] args) {
        FakeMessageQueue mq = new FakeMessageQueue();
        MessageFactory mFactory = new MessageFactory();

        for (int i = 0; i < NUMOFPROBES; i++){
            String messageStr = mq.next();
            String[] msgFields = messageStr.split("\\|");
            Message message = mFactory.getMessage(msgFields);
            message.process();
        }
    }

}
