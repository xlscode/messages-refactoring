package org.lscode;


public class Main {
    private static final int NUMOFPROBES = 15;

    private enum MsgFld {
        HEADER,
        FIELD01,
        FIELD02,
        FIELD03,
        FIELD04,
        FIELD05,
        FIELD06,
        FIELD07,
        FIELD08,
        FIELD09,
        FIELD10,
        FIELD11,
        FIELD12,
        FIELD13,
        FIELD14,
        FIELD15,
        FIELD16,
        FIELD17
    }


    public static void main(String[] args) {
        FakeMessageQueue mq = new FakeMessageQueue();

        for (int i = 0; i < NUMOFPROBES; i++){
            String message = mq.next();
            String[] messageFields = message.split("\\|");

            switch (messageFields[0]){
                case "AST":
                case "ASL":
                    some_method(messageFields[MsgFld.FIELD01.ordinal()], messageFields[MsgFld.FIELD05.ordinal()]);
                    break;
                case "AMG":
                    some_other_method(messageFields[MsgFld.FIELD04.ordinal()], messageFields[MsgFld.FIELD17.ordinal()]);
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
