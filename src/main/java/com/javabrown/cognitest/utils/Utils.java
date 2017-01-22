package com.javabrown.cognitest.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Utils {
    private static PrintStream _realSystemOut = System.out;
    private static PrintStream _out = System.out;

    public static boolean isEmpty(String s) {
        return (s == null) || s.trim().equals("");
    }

    public static boolean isEmpty(String... stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return true;
        }

        for (String s : stringArray) {
            if (isEmpty(s)) {
                return true;
            }
        }

        return false;
    }

    public static String getPolicyKey(String policyId, String policyHolderId) {
        return String.format("policyId=%s|policyHolderId=%s", policyId, policyHolderId);
    }

    public static void disableConsoleOutput() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }
        }));
    }

    public static void enableConsoleOutput() {
        System.setOut(_out);
    }

    public static void println(String str) {
        _realSystemOut.println(str);
    }

    private static class NullOutputStream extends OutputStream {
        @Override
        public void write(int b) {
            return;
        }

        @Override
        public void write(byte[] b) {
            return;
        }

        @Override
        public void write(byte[] b, int off, int len) {
            return;
        }

        public NullOutputStream() {
        }
    }
}

