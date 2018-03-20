package org.lscode;

public abstract class Message {

    public enum MsgFld {
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

    private String[] fields;

    public Message(String[] fields){
        this.fields = fields;
    }

    public abstract void process();

    @Override
    public String toString() {
        return super.toString();
    }

    public String getType(){
        return fields[MsgFld.HEADER.ordinal()];
    }

}
