package org.lscode;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class FakeMessageQueue implements Iterator<String>{

    private enum MsgType {
        AST (5),
        ASL (5),
        AMG (17),
        OMG (17),
        DEF (15);

        private final int fldNo;

        MsgType(int fldNo){
            this.fldNo = fldNo;
        }

        public int getFldNo(){
            return this.fldNo;
        }
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        MsgType mType = generateMsgType();
        System.out.println(">> generated message: " + mType.name());
        return constructMessage(mType);
    }

    private MsgType generateMsgType() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, MsgType.values().length);
        return MsgType.values()[randomNum];
    }

    private String constructMessage(MsgType msgType){
        StringBuilder message = new StringBuilder();
        message.append(msgType.toString());
        int fldNo = msgType.getFldNo();
        for (int i=0; i<fldNo; i++){
            message.append("|");
            message.append(generateFldValue());
        }
        return message.toString();
    }

    private String generateFldValue() {
        return "fld";
    }

}
