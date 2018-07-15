package lib.listeners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNGListener implements IAnnotationTransformer, IRetryAnalyzer{

	int maxCount=1;
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor constructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		//Sets timeout to 10000 when method name is createlead
		if(testMethod.getName().equals("createLead"))
		{
			annotation.setTimeOut(10000);
		}
		if(testMethod.getName().equals("deleteLead"))
		{
			System.out.println("The method getting disabled "+testMethod.getName());
			annotation.setEnabled(true);
		}
	}
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() & maxCount<2)
		{
			maxCount++;
			return true;
		}
		return false;
	}
	

}
