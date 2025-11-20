package _27150;

import java.io.PrintStream;

/**
 * Utility that ensures every console output includes the student ID suffix.
 */
public final class StudentOutput {
    public static final String STUDENT_ID = "27150";

    private static boolean enabled = false;
    private static PrintStream originalStream;

    private StudentOutput() {
    }

    /**
     * Replaces System.out with a stream that appends the student ID to
     * every printed value. Calling this method multiple times is safe.
     */
    public static void enable() {
        if (enabled) {
            return;
        }
        originalStream = System.out;
        System.setOut(new StudentPrintStream(originalStream));
        enabled = true;
    }

    /**
     * Restores the original System.out stream.
     */
    public static void restore() {
        if (!enabled) {
            return;
        }
        System.setOut(originalStream);
        enabled = false;
    }

    private static final class StudentPrintStream extends PrintStream {
        StudentPrintStream(PrintStream delegate) {
            super(delegate, true);
        }

        private String withId(String message) {
            String safe = message == null ? "" : message;
            if (safe.endsWith(StudentOutput.STUDENT_ID)) {
                return safe;
            }
            if (safe.isEmpty()) {
                return StudentOutput.STUDENT_ID;
            }
            return safe + " " + StudentOutput.STUDENT_ID;
        }

        @Override
        public void print(boolean b) {
            super.print(withId(String.valueOf(b)));
        }

        @Override
        public void print(char c) {
            super.print(withId(String.valueOf(c)));
        }

        @Override
        public void print(int i) {
            super.print(withId(String.valueOf(i)));
        }

        @Override
        public void print(long l) {
            super.print(withId(String.valueOf(l)));
        }

        @Override
        public void print(float f) {
            super.print(withId(String.valueOf(f)));
        }

        @Override
        public void print(double d) {
            super.print(withId(String.valueOf(d)));
        }

        @Override
        public void print(char[] s) {
            super.print(withId(String.valueOf(s)));
        }

        @Override
        public void print(String s) {
            super.print(withId(s));
        }

        @Override
        public void print(Object obj) {
            super.print(withId(String.valueOf(obj)));
        }

        @Override
        public void println() {
            super.println(withId(""));
        }

        @Override
        public void println(boolean x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(char x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(int x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(long x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(float x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(double x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(char[] x) {
            super.println(withId(String.valueOf(x)));
        }

        @Override
        public void println(String x) {
            super.println(withId(x));
        }

        @Override
        public void println(Object x) {
            super.println(withId(String.valueOf(x)));
        }
    }
}


