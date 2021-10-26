package loans;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) { System.out.println("Listener on start test " + result.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {System.out.println("Success in listener " + result.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {System.out.println("Failure in listener " + result.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {System.out.println("Skipped by listener " + result.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {System.out.println("On start " + context.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {System.out.println("On finish " + context.getName());
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
	}

}


