package utility;

import org.testng.*;

public class RetryAnalyzer implements ITestListener {
    private int retryCount =0;
   private static final int maxRetryCount = 2;

    private static final int MAX_RETRY_COUNT = 1; // retry whole class only once
    private int retryCounter = 0;

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();

        if (retryCounter < MAX_RETRY_COUNT) {
            retryCounter++;

            System.out.println("Test failed in class: " + result.getTestClass().getName());
            System.out.println(" Retrying all methods of class: " + result.getTestClass().getName());

            // remove failed results so they will be re-run
            context.getFailedTests().getAllResults().clear();
            context.getSkippedTests().getAllResults().clear();
            context.getPassedTests().getAllResults().clear();

            // re-run all tests in this class
            TestRunner runner = (TestRunner) context;
            runner.run();
        }
    }
}