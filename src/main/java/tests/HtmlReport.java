package tests;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HtmlReport {

	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/results.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		ExtentTest test = extent.createTest("TC001", "Create Lead");
		test.assignCategory("Smoke");
		test.assignAuthor("Priya");
		test.pass("DemoSalesManager",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.pass("Password");
		extent.flush();
		

	}

}
