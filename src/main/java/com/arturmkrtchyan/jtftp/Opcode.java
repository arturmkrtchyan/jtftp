package com.arturmkrtchyan.jtftp;

public enum Opcode {

    RRQ(1, "Read request"),
    WRQ(2, "Write request"),
    DATA(3, "Data"),
    ACK(4, "Acknowledgment"),
    ERROR(5, "Error"),
    OACK(6, "Option Acknowledgment");

    private int value;
    private String description;

    private Opcode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public Opcode valueOf(int value) {
        for (Opcode op : com.arturmkrtchyan.jtftp.Opcode.values()) {
            if (op.value() == value) {
                return op;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Opcode{" + value + ", " + description + '}';
    }
}
