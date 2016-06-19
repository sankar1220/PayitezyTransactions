package com.payitezy;

public enum DBSequences {

    ADMINUSER("AUSER"),
    USERS("USER"),
    EMPLOYEE("EMPLOYEE"),
    RECEIPT("RCPT"),
    CUSTOMER("CUST"),
    APIDETAILS("APIDETAILS"),
    PAYOPER("PAYOPER");
    private String sequenceName;

    DBSequences(final String sequenceCode) {
        sequenceName = sequenceCode;
    }

    public String getSequenceName() {
        return sequenceName;
    }

}
