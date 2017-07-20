package com.softserve.edu.registrator.tools;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class CurrentTime {

    private static enum TimeTemplates {
        TIME_FULL("yyyy_MM_dd_HH-mm-ss"),
        TIME_HHMMSS("yyyy_MM_dd_HH-mm-ss"),
        TIME_MMSS("yyyy_MM_dd_HH-mm-ss");
        //
        private String field;

        private TimeTemplates(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private CurrentTime() {
    }

    public static String get() {
        return get(TimeTemplates.TIME_FULL);
    }

    public static String get(TimeTemplates template) {
        return new SimpleDateFormat(template.toString()).format(new Date());
    }

}
