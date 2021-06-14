package com.seleniumassessment.SeleniumAssessment;

public class Testcase {

		// TODO Auto-generated method stub
		static BaseMethods basemethod = new BaseMethods();

		public static void main(String args[]) {
		
		basemethod.startChrome();
		basemethod.geturl();
		basemethod.login();
		basemethod.navigation();
		basemethod.checksubcatagory("10T46");
		basemethod.checkproductname("Bristol H22J38BABC, Reciprocating Compressor, 37,800 Btuh 208/230V, R-22, 1 Phase");
		basemethod.checkproductprice("Your Price: $1173.00 |List price: $2697.");
		basemethod.driverclose();
		}
}
