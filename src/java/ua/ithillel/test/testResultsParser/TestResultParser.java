package ua.ithillel.test.testResultsParser;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestResultParser {

    public TestResult parser(Object testFilePath){

        TestResult testResult = new TestResult();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(findIncomeType(testFilePath)))) {

            String line;
            while ((line = bufferedReader.readLine()) != null){

                if (line.contains("DATE-TIME")){
                    String[] split = line.split(": ");
                    testResult.setTestStartedAt(new SimpleDateFormat("dd.MM.yyyy-HH:mm:SSSS").parse(split[1]));
                } else if (line.contains("tests found")) {
                    testResult.setTotalAmountOfTests(findNumberOf(line));
                } else if (line.contains("tests successful")) {
                    testResult.setSuccessfulTests(findNumberOf(line));
                } else if (line.contains("tests failed")) {
                    testResult.setFailedTests(findNumberOf(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено " + testFilePath);
        } catch (IOException e) {
            System.out.println("Неможливо прочитати файл!");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return testResult;
    }

    private int findNumberOf(String str){
        return new Scanner(str).useDelimiter("\\D+").nextInt();
    }

    private File findIncomeType(Object o){
        File testReportFile = null;
        if (o instanceof String) {
            testReportFile = new File((String) o);
        } else if (o instanceof Path) {
            testReportFile = ((Path) o).toFile();
        } else if (o instanceof File) {
            testReportFile = (File) o;
        } else {
            throw new IllegalArgumentException("Тип даних не підтримується: " + o.getClass());
        }
        return testReportFile;
    }
}
