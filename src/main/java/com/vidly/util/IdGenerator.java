package com.vidly.util;

import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final int _MACHINE_IDENTIFIER;
    private static final short _PROCESS_IDENTIFIER;
    private static final AtomicInteger _NEXT_COUNTER = new AtomicInteger(new SecureRandom().nextInt());

    static {
        try {
            // Generate a machine identifier
            int machinePiece;
            try {
                StringBuilder sb = new StringBuilder();
                Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
                while (e.hasMoreElements()) {
                    NetworkInterface ni = e.nextElement();
                    sb.append(ni.toString());
                }
                machinePiece = sb.toString().hashCode();
            } catch (Throwable t) {
                machinePiece = new SecureRandom().nextInt();
            }

            // Generate process identifier
            int processPiece;
            try {
                processPiece = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
            } catch (Throwable t) {
                processPiece = new SecureRandom().nextInt();
            }

            _MACHINE_IDENTIFIER = machinePiece & 0x00ffffff;
            _PROCESS_IDENTIFIER = (short) processPiece;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String generate() {
        ByteBuffer buffer = ByteBuffer.allocate(12);

        int timestamp = (int) (System.currentTimeMillis() / 1000);
        buffer.putInt(timestamp); // 4 bytes

        buffer.put((byte) (_MACHINE_IDENTIFIER >> 16));
        buffer.put((byte) (_MACHINE_IDENTIFIER >> 8));
        buffer.put((byte) _MACHINE_IDENTIFIER);

        buffer.putShort(_PROCESS_IDENTIFIER);

        int counter = _NEXT_COUNTER.getAndIncrement();
        buffer.put((byte) (counter >> 16));
        buffer.put((byte) (counter >> 8));
        buffer.put((byte) counter);

        byte[] bytes = buffer.array();
        StringBuilder sb = new StringBuilder(24);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }
}
