package com.ap.ui.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter{
	private ExtentReports extent;
//it's method we put 3arguments	
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, 
		String outputDirectory){//outputdirectory is results  pass, fail and skipped
	//creating an objest for extent report,crat a vertual obj 
	extent = new ExtentReports(outputDirectory + File.separator
			+ "Extent.html", true);//when generate report 
	//if you dont recieve any result generate the report for me if you do genera it(boolean)
	//using for loop get the results from the child suite class
	//map obtain a key value, it cannot be duplicate, and then it will map to one location , that one location 
	//will be extent report , map is interfacing java,in our case its sharing the value with java and extent repoet
	//its seperates the result
	//":" conditional operator,your scipt shou;d run on one suite or multiple suites
	for(ISuite suite : suites){
		Map<String, ISuiteResult>result = suite.getResults();
	//continuing loop 
	for(ISuiteResult r : result.values()){
		ITestContext context =r.getTestContext();
	//emaking the context capturing the result	
		buildTestNo(context.getPassedTests(), LogStatus.PASS);
		buildTestNo(context.getFailedTests(), LogStatus.FAIL);
		buildTestNo(context.getSkippedTests(), LogStatus.SKIP);
			
	}
}
	//as soon as completed the code flush is adding the result to the html file
extent.flush();
extent.close();

}
//we donot want to share this report to any other project so its private
//private construc calling hte test  no caclling extent test
private void buildTestNo(IResultMap tests, LogStatus status){
	ExtentTest test;
	
	
	if(tests.size()>0){
		for (ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());
			//duration of the test how much time it going to take
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			//strig to to group /organize for more efficient to read the result like pass fail skipped
			for(String group : result.getMethod().getGroups())
				test.assignCategory(group);
			//if therer is error you log it if not and "ed" basically  passed failed
			//null is an empty string
			if(result.getThrowable() !=null){
				test.log(status, result.getThrowable());
			}else{
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				
		}
			extent.endTest(test);
			
	}
}
}
//private constr its local machine time
private Date getTime(long millis){
	Calendar calender = Calendar.getInstance();
	calender.setTimeInMillis(millis);
	return calender.getTime();
	
	
}
}
