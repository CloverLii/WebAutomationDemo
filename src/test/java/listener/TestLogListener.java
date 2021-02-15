
package listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import util.ScreenshotUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.ITestContext;

/**
 * 
 * Write log during tests execution, get screenshot when test fails
 * @author cloverli
 * @date 08/02/2021
 *
 */
public class TestLogListener extends TestListenerAdapter {
	
	private static Logger log = LoggerFactory.getLogger(TestLogListener.class);
   
	@Override
    public void onStart(ITestContext iTestContext) {
        super.onStart( iTestContext );
        log.info( String.format( "==== OnStart: [%s]...====", iTestContext.getName() ) );
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart( result );
        log.info( String.format( "==== OnTestStart:[%s.%s]...====", result.getInstanceName(), result.getName()) );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess( result );
        log.info( String.format( "==== Test Pass: [%s.%s]====", result.getInstanceName(), result.getName()) );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure( result );
        log.error( String.format( "==== Test Fails: [%s.%s], because：\n%s====", result.getInstanceName(), result.getName(), result.getThrowable() ));
        ScreenshotUtil.capture(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        super.onTestSkipped( result );
        log.info( String.format( "==== Test Skipped: [%s.%s]...====", result.getInstanceName(), result.getName()) );
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish( iTestContext );
        log.info( String.format( "==== OnFinish: [%s]...====", iTestContext.getName() ) );
    }
}