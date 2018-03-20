package org.lscode;

public class Main {
    private static final int NUMOFPROBES = 15;

    public static void main(String[] args) {
        FakeMessageQueue mq = new FakeMessageQueue();

        for (int i = 0; i<NUMOFPROBES; i++){
            String message = mq.next();
            String[] messageFields = message.split("\\|");

            switch (messageFields[0]){
                case "AST":
                case "ASL":
                    some_method(messageFields[1], messageFields[5]);
                    break;
                case "AMG":
                    some_other_method(messageFields[4], messageFields[17]);
                    break;
                case "OMG":
                    System.out.println("long code block for OMG");
                    //long code block
                    break;
                default:
                    System.out.println("default block");
            }
        }
    }

    private static void some_method(String msgField1, String msgField2) {
        //do sth
        System.out.println("some_method");
    }

    private static void some_other_method(String msgField1, String msgField2) {
        //do sth
        System.out.println("some_other_method");
    }

}
