package com.slot2junit;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class AppTest{
	
	@AfterEach            //@-->annotation for all annotation import junit jupiter
	 void aftertestcase() {
		System.out.println("After each tests");
	}
	@BeforeEach
	 void beforeeachtest() {
		System.out.println("Before each tests");
	}

	@AfterAll
	 static void aftertestcase11() {
		System.out.println("After all tests");
	}
	@BeforeAll
	 static void beforetestcase1() {
		System.out.println("Before all tests");
	}

	
	@Order(3)
	@Test                   //import org.junit jupiter api test
	void testadding() {
		App ap=new App();    //creating object
		int exp=8;
		int res=ap.adding(2,3);         //it doesnt match wen exp=6 &res(2,3) it fails
		                   
		System.out.println("This is first testcase");
	//	assertEquals(exp,res);    //matching expected and actual values
		assertNotEquals(exp,res);    //not equal -not matching exp & res
	}
	
	@Order(2)
	@Test
	void testEven()
	{
		
		System.out.println("This is second testcase");
		// assertTrue(new App().checkEven(8))  ;      //true for even no. false for odd no.
		assertFalse(new App().checkEven(9));
		
	}
	
	
	@Test
	void testsort() {
		
		int ar[]= {82,90,26,8,15,48};
		int exp[]= {8,15,26,48,82,90};
		int res[]=new App().sortingofarray(ar);
		
		assertArrayEquals(exp,res);
	}
	
	
	@Test
	void testiterate() {
		
		ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(5,10,8,65,71));

		ArrayList<Integer> al2=new ArrayList<Integer>(Arrays.asList(5,10,8,65,71));

		assertIterableEquals(al,al2);

	}
	
	@DisabledOnJre(JRE.OTHER)
	@Test
	void testString() {

	//	assertSame("Hello World",new App().wishme());
	
		assertNotSame("HELLO World",new App().wishme());
	}
	
	@Order(1)
	@DisplayName(value="this is division")
	@Test
	void testdivide() {
		
		assertThrows(ArithmeticException.class,()->new App().divide(15, 0));
	}
	
	@DisabledOnOs(OS.WINDOWS)   //or (OS.MAC)
	@EnabledOnOs(OS.WINDOWS)      //or (OS.MAC)
	@Test
	void testdivide2() {
		
		assertAll(
				()->assertEquals(5,new App().divide(15, 3)),
				()->assertThrows(ArithmeticException.class,()->new App().divide(15, 0)),
				()->assertEquals(-2,new App().divide(-8, 4))
				);
	}
	
	
	@Disabled
	@Test
	void testunderdev() {
		fail("Under development");
	}
	
}