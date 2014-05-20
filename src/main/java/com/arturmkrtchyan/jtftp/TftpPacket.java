package com.arturmkrtchyan.jtftp;

public final class TftpPacket {

    private final Opcode opcode;
    private final TransferMode transferMode;
    private final String fileName;
    private final short blockNumber;
    private final byte[] data;
    private final short errorCode;
    private final String errorMessage;


    private TftpPacket(Opcode opcode, TransferMode transferMode, String fileName, short blockNumber, byte[] data, short errorCode, String errorMessage) {
        this.opcode = opcode;
        this.transferMode = transferMode;
        this.fileName = fileName;
        this.blockNumber = blockNumber;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * ACK Packet
     *
     *   2 bytes     2 bytes
     *  ---------------------
     * | Opcode |   Block #  |
     *  ---------------------
     *
     * @param blockNumber
     * @return
     */
    public static TftpPacket ack(final short blockNumber) {
        return new TftpPacket(Opcode.ACK, null, null, blockNumber, null, (short) 0, null);
    }

    /**
     * Error Packet
     *
     *   2 bytes     2 bytes      string    1 byte
     *  -----------------------------------------
     * | Opcode |  ErrorCode |   ErrMsg   |   0  |
     *  -----------------------------------------
     *
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public static TftpPacket error(final short errorCode, final String errorMessage) {
        return new TftpPacket(Opcode.ERROR, null, null, (short) 0, null, errorCode, errorMessage);
    }

    /**
     * Data Packet
     *
     *   2 bytes     2 bytes      n bytes
     *  ----------------------------------
     * | Opcode |   Block #  |   Data     |
     *  ----------------------------------
     *
     * @param blockNumber
     * @param data
     * @return
     */
    public static TftpPacket data(final short blockNumber, final byte[] data) {
        return new TftpPacket(Opcode.DATA, null, null, blockNumber, data, (short) 0, null);
    }

    /**
     * RRQ Packet
     *
     *   2 bytes    string   1 byte     string   1 byte
     *  -----------------------------------------------
     * | 01/02 |  Filename  |   0  |    Mode    |   0  |
     *  -----------------------------------------------
     *
     * @param fileName
     * @param mode
     * @return
     */
    public static TftpPacket rrq(final String fileName, final TransferMode mode) {
        return new TftpPacket(Opcode.RRQ, mode, fileName, (short) 0, null, (short) 0, null);
    }

    /**
     *
     * WRQ Packet
     *
     *   2 bytes    string   1 byte     string   1 byte
     *  -----------------------------------------------
     * | 01/02 |  Filename  |   0  |    Mode    |   0  |
     *  -----------------------------------------------
     *
     * @param fileName
     * @param mode
     * @return
     */
    public static TftpPacket wrq(final String fileName, final TransferMode mode) {
        return new TftpPacket(Opcode.WRQ, mode, fileName, (short) 0, null, (short) 0, null);
    }


    public Opcode opcode() {
        return opcode;
    }

    public TransferMode transferMode() {
        return transferMode;
    }

    public String fileName() {
        return fileName;
    }

    public short blockNumber() {
        return blockNumber;
    }

    public byte[] data() {
        return data;
    }

    public short errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
