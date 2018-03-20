package org.lscode;

public class OMGMessage extends Message{

    public OMGMessage(String[] fields) {
        super(fields);
    }

    @Override
    public void process() {
        System.out.println("long code block for an OMG type message");
    }
}
