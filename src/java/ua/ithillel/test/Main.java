package ua.ithillel.test;

import ua.ithillel.test.projectTestRunner.ProjectTestRunner;
import ua.ithillel.test.testResultsParser.TestResultParser;
import ua.ithillel.test.tests.ArraysMethodsTest;
import ua.ithillel.test.tests.SimpleMathLibraryTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner();

        projectTestRunner.runTestByName("ua.ithillel.test.tests.SimpleMathLibraryTest");
        projectTestRunner.runTestByClass(SimpleMathLibraryTest.class);
        projectTestRunner.runTestByClasses(SimpleMathLibraryTest.class, ArraysMethodsTest.class);
        projectTestRunner.runTestByNames("ua.ithillel.test.tests.SimpleMathLibraryTest", "ua.ithillel.test.tests.ArraysMethodsTest");
        projectTestRunner.runTestByPackage("ua.ithillel.test");

        String testFileReportPath = ("");

        TestResultParser testResultParser = new TestResultParser();
        System.out.println(testResultParser.parser(testFileReportPath));

        Path path = Paths.get(testFileReportPath);
        System.out.println(testResultParser.parser(path));

        File file = new File(testFileReportPath);
        System.out.println(testResultParser.parser(file));

    }
}
