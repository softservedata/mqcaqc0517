package com.softserve.edu.registrator.tools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.softserve.edu.registrator.pages.Application;

public class CaptureScreen {

    private final String IMAGE_SUFFIX = "_CaptureScreenImage.png";
    private final String SOURCE_SUFFIX = "_CaptureSourceCode.txt";
    private final String DEFAULT_DIRECTORY = "test-output";
    private final String MAVEN_DIRECTORY = "surefire.reports.directory";
    private final String SLASH = "/";
    private final String FAILED_TO_CREATE = "Failed to create screenshot: %s";

    private String getOutputDirectory() {
        String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
        if ((outputDirectory == null) || (outputDirectory.isEmpty())) {
            outputDirectory = DEFAULT_DIRECTORY;
        }
        // System.out.println("\t+++++outputDirectory = " + outputDirectory);
        return outputDirectory + SLASH;
    }

    private String getRelativeFileName() {
        return getOutputDirectory() + CurrentTime.get();
    }

    private String getRelativePath() {
        String classPath = CaptureScreen.class.getResource(SLASH).getPath().substring(1);
        classPath = classPath.substring(0, classPath.length() - 1);
        classPath = classPath.substring(0, classPath.lastIndexOf(SLASH) + 1);
        //System.out.println("\t\t+++++ classPath = " + classPath);
        return classPath;
    }

    private String getAbsolutePathImageFileName() {
        //System.out.println("\t\t\t+++ getAbsolutePathFileName() = " 
        //        + CaptureScreen.class.getResource("/").getPath().substring(1)
        //        + getRelativePathFileName());
        return getRelativePath() + getRelativeFileName() + IMAGE_SUFFIX;
    }

    private String getAbsolutePathSourceFileName() {
        //System.out.println("\t\t\t+++ getAbsolutePathFileName() = " 
        //        + CaptureScreen.class.getResource("/").getPath().substring(1)
        //        + getRelativePathFileName());
        return getRelativePath() + getRelativeFileName() + SOURCE_SUFFIX;
    }

    /**
     * @return Absolute path of filename.
     */
    public String takeScreen(String absolutePathFileName) {
        File srcFile = ((TakesScreenshot) Application.get().getBrowser())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(absolutePathFileName));
        } catch (IOException e) {
            throw new RuntimeException(String.format(FAILED_TO_CREATE, absolutePathFileName), e);
        }
        return absolutePathFileName;
    }

    public String takeScreen() {
        return takeScreen(getAbsolutePathImageFileName());
    }

    public String takeSourceCode(String absolutePathFileName) {
        String srcFile = Application.get().getBrowser()
                .getPageSource();
        //System.out.println("\t\t srcFile = " + srcFile);
        try {
            FileUtils.writeStringToFile(new File(absolutePathFileName),
                    srcFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(String.format(FAILED_TO_CREATE, absolutePathFileName), e);
        }
        return absolutePathFileName;
    }

    public String takeSourceCode() {
        return takeSourceCode(getAbsolutePathSourceFileName());
    }

}
