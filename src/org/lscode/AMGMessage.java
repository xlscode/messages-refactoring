package org.lscode;

public class AMGMessage extends Message{

    public AMGMessage(String[] fields) {
        super(fields);
    }

    @Override
    public void process() {
        System.out.println("some_other_method (for an AMG type message)");
    }
}
