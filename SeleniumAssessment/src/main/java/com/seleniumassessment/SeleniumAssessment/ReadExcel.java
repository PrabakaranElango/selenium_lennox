package com.seleniumassessment.SeleniumAssessment;


public class ReadExcel {
		
     ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\sabariecs\\Downloads\\Prabakaran\\Lennox.xlsx");

	
	public String getexecution(){		
		String execution  = excel.getdata(1, 1, 0);
		return execution;
	}
	
	public String getTestCaseID(){		
		String testcaseid  = excel.getdata(1, 1, 1);
		return testcaseid;
		
	}public String getTestCaseName(){		
		String testcasename  = excel.getdata(1, 1, 2);
		return testcasename;
		
	}public String getTestCaseDescription(){		
		String testcasedes  = excel.getdata(1, 1, 3);
		return testcasedes;
		
	}public String getemailID(){		
		String emailid  = excel.getdata(1, 1, 4);
		return emailid;
		
	}public String getPassword(){		
		String password  = excel.getdata(1, 1, 5);
		return password;
		
	}public String getLinkName(){		
		String linkname  = excel.getdata(1, 1, 6);
		return linkname;
		
	}public String getPageNavigation(){		
		String pagenavigation  = excel.getdata(1, 1, 7);
		return pagenavigation;
		
	}public String getPageDescription(){		
		String pagedescription  = excel.getdata(1, 1, 8);
		return pagedescription;
	}
	
	public String getPageCatalog(){		
		String pagecatalog  = excel.getdata(1, 1, 9);
		return pagecatalog;
	}
	
	public double getPrice(){		
		double price  = excel.getdataint(1, 1, 10);
		return price;
	}
	
}
