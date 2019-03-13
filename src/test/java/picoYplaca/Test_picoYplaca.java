package picoYplaca;

import static org.junit.Assert.*;

import org.junit.Test;


public class Test_picoYplaca {
	/*
	Assumptions: 
	DATE format: String (DD/MM/YYYY)
	TIME format: String ("AA:BB"), using time as 24 hour format.
	PLATE NUMBER: WILL GO FROM 0 TO 999 LIMITING TO A 3 DIGITS FORMAT
	 */
	// TEST FOR NO TIME
	@Test
	public void test() {
		picoYplaca no_info =new picoYplaca(10,"2019/12/31","");
		assertFalse("should fail time not valid",no_info.Should_ride());
	}
	
	@Test
	// TEST FOR AN INVALID NUMBER
	public void test2() {
		
		picoYplaca no_info =new picoYplaca(-1,"2019/12/1","19:00");
		assertFalse("should fail negative time",no_info.Should_ride());
	}
	@Test
	// TEST FOR NULL POINTERS on date
	public void test3() {
		picoYplaca no_info =new picoYplaca(100,null,"19:00");
		assertFalse("should fail null pointer",no_info.Should_ride());
	}
	@Test
	// TEST FOR NULL POINTERS on time
	public void test4() {
		picoYplaca no_info =new picoYplaca(100,"1999/05/18",null);
		assertFalse("should fail null pointer on time",no_info.Should_ride());
	}
	
	@Test
	// TEST FOR A MONDAY  IN PICO Y PLACA CONDITIONS

	public void test5() {
		picoYplaca no_info =new picoYplaca(101,"01/02/1999","08:00");
		assertFalse(" DIGIT 1, MONDAY, IN PICO TIME",no_info.Should_ride());
	}
	@Test
	//TEST FOR A MONDAY  IN PICO Y PLACA CONDITIONS
	public void test6() {
		picoYplaca no_info =new picoYplaca(902,"04/01/1999","17:30");
		assertFalse("DIGIT 2, MONDAY, IN PICO TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR A MONDAY NOT IN PICO Y PLACA CONDITIONS
	public void test5_outside() {
		picoYplaca no_info =new picoYplaca(101,"01/02/1999","10:00");
		assertTrue("DIGIT 1, MONDAY, OUTSIDE TIME",no_info.Should_ride());
	}
	@Test
	//TEST FOR A MONDAY  NOT IN PICO Y PLACA CONDITIONS
	public void test6_outside() {
		picoYplaca no_info =new picoYplaca(902,"04/01/1999","21:30");
		assertTrue("DIGIT 2,MONDAY, OUTSIDE TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR A TUESDAY IN PICO Y PLACA CONDITIONS
	public void test7() {
		picoYplaca no_info =new picoYplaca(333,"12/03/2019","09:30");
		assertFalse("DIGIT 3, TUESDAY, IN TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR TUESDAY NOT IN PICO Y PLACA CONDITIONS
	public void test8() {
		picoYplaca no_info =new picoYplaca(104,"12/03/2019","06:59");
		assertTrue("DIGIT 4, TUESDAY, OUTSIDE TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR A WEDNESDAY IN PICO Y PLACA CONDITIONS
	public void test9() {
		picoYplaca no_info =new picoYplaca(505,"20/03/2019","19:30");
		assertFalse("DIGIT 5, WEDNESDAY, IN TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR A WEDNESDAY NOT IN PICO Y PLACA CONDITIONS
	public void test10() {
		picoYplaca no_info =new picoYplaca(559,"20/03/2019","12:00");
		assertTrue("DIGIT 9, WEDNESDAY, OUTSIDE TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR A THRUSDAY IN PICO Y PLACA CONDITIONS
	public void test11() {
		picoYplaca no_info =new picoYplaca(558,"07/03/2019","16:00");
		assertFalse("DIGIT 8, THURSDAY, IN TIME ",no_info.Should_ride());
	}

	@Test
	// TEST FOR A THRUSDAY NOT IN PICO Y PLACA CONDITIONS
	public void test12() {
		picoYplaca no_info =new picoYplaca(559,"14/03/2019","17:00");
		assertTrue("DIGIT 9, THURSDAY, IN TIME",no_info.Should_ride());
	}

	@Test
	// TEST FOR FRIDAY, NOT IN PICO Y PLACA CONDITIONS
	public void test13() {
		picoYplaca no_info =new picoYplaca(108,"15/03/2019","19:30");
		assertTrue(" DIGIT 8, FRIDAY, IN TIME ",no_info.Should_ride());
	}
	@Test
	// TEST FOR FRIDAY IN PICO Y PLACA CONDITIONS
	public void test14() {
		picoYplaca no_info =new picoYplaca(100,"08/03/2019","16:00");
		assertFalse("DIGIT 0, FRIDAY, IN TIME",no_info.Should_ride());
	}
	@Test
	// TEST FOR SATURDAY, NOT IN PICO Y PLACA CONDITIONS
	public void test15() {
		picoYplaca no_info =new picoYplaca(108,"16/03/2019","19:30");
		assertTrue(" should always pass",no_info.Should_ride());
	}
	@Test
	// TEST FOR SUNDAY IN PICO Y PLACA CONDITIONS
	public void test16() {
		picoYplaca no_info =new picoYplaca(100,"09/03/2019","18:00");
		assertTrue("should pass no matter",no_info.Should_ride());
	}
	
	


}
