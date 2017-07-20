package com.softserve.edu.registrator.tools;

import org.testng.Reporter;

public class ReporterWrapper {
    
    private static enum ReporterTags {
        BR_ERROR("<br>[ERROR] "),
        BR_WARNING("<br>[WARNING] "),
        BR_INFO("<br>[INFO] "),
        BR_DEBUG("<br>[DEBUG] ");
        //
        private String field;

        private ReporterTags(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
    
    private static enum ReporterLevels {
        ERROR_LEVEL(2),
        WARNING_LEVEL(5),
        INFO_LEVEL(7),
        DEBUG_LEVEL(9);
        //
        private int level;

        private ReporterLevels(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }
    }

    //private static final String IMG_TEMPLATE = "<br><img src='%s' alt='could not take screen shot' width='80%' height='80%'>";
    private static final String IMG_TEMPLATE = "<br><div><image style=\"max-width:90%%\" src=\"%s\"  alt=\"could not take screen shot\" /></div>";
    private static final String SCREENSHOT_FILENAME = "<br><p>Screenshot filename is %s</p>";
    private static final String SOURCECODE_FILENAME = "<br><p><a href='%s'>Source Code</a> filename is %s</p>";
    private static final String SPACE = " ";
    //
    private static volatile ReporterWrapper instance = null;
    private boolean consoleOutput;

    private ReporterWrapper(boolean consoleOutput) {
        this.consoleOutput = consoleOutput;
        // TODO Set default verbose.
    }

    public static ReporterWrapper get() {
        return get(true);
    }

    public static ReporterWrapper get(boolean consoleOutput) {
        if (instance == null) {
            synchronized (ReporterWrapper.class) {
                if (instance == null) {
                    instance = new ReporterWrapper(consoleOutput);
                }
            }
        }
        return instance;
    }
    
    public void error(String message){
        Reporter.log(ReporterTags.BR_ERROR.toString() + CurrentTime.get() + SPACE + message,
                ReporterLevels.ERROR_LEVEL.getLevel(), consoleOutput);
    }

    public void warning(String message){
        Reporter.log(ReporterTags.BR_WARNING.toString() + CurrentTime.get() + SPACE + message,
        ReporterLevels.WARNING_LEVEL.getLevel(), consoleOutput);
    }

    public void info(String message){
        Reporter.log(ReporterTags.BR_INFO.toString() + CurrentTime.get() + SPACE + message,
                ReporterLevels.INFO_LEVEL.getLevel(), consoleOutput);
    }

    public void debug(String message){
        Reporter.log(ReporterTags.BR_DEBUG.toString() + CurrentTime.get() + SPACE + message,
                ReporterLevels.DEBUG_LEVEL.getLevel(), consoleOutput);
    }

    public String addScreenShot() {
        String screenFileName = new CaptureScreen().takeScreen();
        Reporter.log(String.format(SCREENSHOT_FILENAME, screenFileName));
        Reporter.log(String.format(IMG_TEMPLATE, screenFileName));
        return screenFileName;
    }

    public String addSourceCode() {
        String sourceCodeFileName = new CaptureScreen().takeSourceCode();
        Reporter.log(String.format(SOURCECODE_FILENAME, sourceCodeFileName, sourceCodeFileName));
        return sourceCodeFileName;
    }

}
