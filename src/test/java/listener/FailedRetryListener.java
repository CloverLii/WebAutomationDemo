package listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//TODO: add failed test to confirm
public class FailedRetryListener implements IAnnotationTransformer {
   
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        {
            IRetryAnalyzer retry = annotation.getRetryAnalyzer();
            if (retry == null) {
                annotation.setRetryAnalyzer(FailedRetryRunner.class);
            }
        }
    }
}
