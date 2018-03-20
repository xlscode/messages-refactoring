package org.lscode;

public class ASTMessage extends Message{

    public ASTMessage(String[] fields) {
        super(fields);
    }

    @Override
    public void process() {
        System.out.println("some_method (for an AST type message)");
    }
}
