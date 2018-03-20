package org.lscode;

public class ASLMessage extends Message{

    public ASLMessage(String[] fields) {
        super(fields);
    }

    @Override
    public void process() {
        System.out.println("some_method (for an ASL type message)");
    }
}
