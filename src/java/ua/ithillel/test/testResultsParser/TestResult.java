package ua.ithillel.test.testResultsParser;

import java.util.Date;

public class TestResult {

    private int totalAmountOfTests;
    private int successfulTests;
    private int failedTests;
    private Date testStartedAt;


    public int getTotalAmountOfTests() {
        return totalAmountOfTests;
    }

    public void setTotalAmountOfTests(int totalAmountOfTests) {
        this.totalAmountOfTests = totalAmountOfTests;
    }

    public int getSuccessfulTests() {
        return successfulTests;
    }

    public void setSuccessfulTests(int successfulTests) {
        this.successfulTests = successfulTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public Date getTestStartedAt() {
        return testStartedAt;
    }

    public void setTestStartedAt(Date testStartedAt) {
        this.testStartedAt = testStartedAt;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "totalAmountOfTests=" + totalAmountOfTests +
                ", successfulTests=" + successfulTests +
                ", failedTests=" + failedTests +
                ", testStartedAt=" + testStartedAt +
                '}';
    }
}
