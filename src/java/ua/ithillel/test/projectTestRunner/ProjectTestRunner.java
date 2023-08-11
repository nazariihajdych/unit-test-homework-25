package ua.ithillel.test.projectTestRunner;

import org.junit.platform.console.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectTestRunner {

    private final String testReportFolder = "/Users/nazar/IdeaProjects/homework-26-unit-tests/src/java/ua/ithillel/test/testReports";


    public void runTestByName(String name){
        String[] args = new String[] {"--disable-banner","-c", name};
        runTests(args);
    }

    public void runTestByClass(Class<?> aClass){
        runTestByName(aClass.getName());
    }

    public void runTestByNames(String ... names){
        List<String> testNamesAndKeys = new ArrayList<>();
        testNamesAndKeys.add("--disable-banner");

        for (int i = 0; i < names.length; i++) {
            testNamesAndKeys.add("-c");
            testNamesAndKeys.add(names[i]);
            }

        String[] namesArray = new String[testNamesAndKeys.size()];
        testNamesAndKeys.toArray(namesArray);

        runTests(namesArray);

    }

    public void runTestByClasses(Class<?> ... aClasses){
        String[] classNames = new String[aClasses.length];
        for (int i = 0; i < aClasses.length; i++) {
            classNames[i] = aClasses[i].getName();
        }
        runTestByNames(classNames);
    }

    public void runTestByPackage(String packageName){
        String[] args = new String[] {"--disable-banner", "-p", packageName};
        runTests(args);
    }

    private void runTests(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:SSSS");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintWriter printWriter = new PrintWriter(printStream);
        PrintWriter printErrorWriter = new PrintWriter(System.err);

        ConsoleLauncher.run(printWriter, printErrorWriter, args);


        String consoleOutput = outputStream.toString();

        System.out.println(consoleOutput);


        try (PrintWriter filePrintWriter = new PrintWriter(new FileWriter(testReportFolder + "/test_" + dateFormat.format(new Date()) + ".txt"))) {
            filePrintWriter.write("DATE-TIME: " + dateFormat.format(new Date()));
            filePrintWriter.println();
            filePrintWriter.println(consoleOutput);
        } catch (IOException e) {
            System.out.println("Помилка запису в файл: " + e.getMessage());
        }
    }

}
