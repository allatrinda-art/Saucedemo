package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {

        private int attempt = 1;
        private static final int MAX_RETRY = 3;

        @Override
        public boolean retry(ITestResult iTestResult) {  //??? что это
            if (!iTestResult.isSuccess()) { //успешная ли попытка выполнить тест
                if (attempt < MAX_RETRY) { //не больше 3х раз проверить условие
                    attempt++;
                    iTestResult.setStatus(ITestResult.FAILURE);
                    System.out.println("Retrying once again");
                    return true;
                } else {
                    iTestResult.setStatus(ITestResult.FAILURE);
                }
            } else {
                iTestResult.setStatus(ITestResult.SUCCESS);
            }
            return false;
        }

    }
