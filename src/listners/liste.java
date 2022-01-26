package listners;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class liste extends TestListenerAdapter{

	public void OnTestStart(ITestResult tr){

		System.out.println("Starttest");

	}
	public void OnTestPass(ITestResult tr){

		System.out.println("testpass of the java");

	}
	public void OnTestFail(ITestResult tr){

		System.out.println("testfail of the java");

	}

	public void OnTestSkip(ITestResult tr){

		System.out.println("Testkip");

	}


}
