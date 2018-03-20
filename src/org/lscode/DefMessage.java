package org.lscode;

public class DefMessage  extends Message{

    public DefMessage(String[] fields) {
        super(fields);
    }

    @Override
    public void process() {
        System.out.println("default block a message");
    }
}
