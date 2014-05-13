package com.arturmkrtchyan.jtftp;

public enum ErrorCode {

    UNDEF(0, "Not defined, see error message (if any)."),
    FILE_NOT_FOUND(1, "File not found."),
    ACCESS_VIOLATION(2, "Access violation."),
    DISK_FULL(3, "Disk full or allocation exceeded."),
    ILLEGAL_OP(4, "Illegal TFTP operation."),
    UNKNOWN_ID(5, "Unknown transfer ID."),
    FILE_EXISTS(6, "File already exists."),
    NO_SUCH_USER(7, "No such user."),
    OPTION_NEGOCIATION(8, "Option negociation failed.");

    private int value;
    private String description;

    private ErrorCode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public ErrorCode valueOf(int value) {
        for (ErrorCode code : ErrorCode.values()) {
            if (code.value() == value) {
                return code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ErrorCode{" + value + ", " + description + '}';
    }
}
