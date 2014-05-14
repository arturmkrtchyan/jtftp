package com.arturmkrtchyan.jtftp;

public enum TransferMode {

    NETASCII(0, "Netascii transfer mode."),
    OCTET(1, "octet transfer mode.");

    private int value;
    private String description;

    private TransferMode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public TransferMode valueOf(int value) {
        for (TransferMode mode : TransferMode.values()) {
            if (mode.value() == value) {
                return mode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TransferMode{" + value + ", " + description + '}';
    }
}
