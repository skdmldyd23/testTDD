package testTdd;

import junit.framework.TestCase;

public class SubDateTest extends TestCase {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(SubDateTest.class);
		
		//final 마지막으로 로그를 찍어보면 정상적으로 출력이 되는 것을 알 수 있다.
		System.out.println(SubDate.sub("20190801", "20190902"));
		System.out.println(SubDate.sub("20190902", "20190801"));
	}

	// ---------------------------------------------p2
	public void testGetYearDay() {
		assertEquals(0, SubDate.getYearDay(1));
		assertEquals(365, SubDate.getYearDay(2));
//      위 테스트 코드의 의도는 다음과 같다.
		//
//            0년이란 것은 존재하지 않기 때문에 1년까지의 총 일 수는 0이 되어야 한다. (최초 일자를 1년 1월 1일이라고 나름대로 설정한 것이다.)
//            2년 까지의 총 일 수는 1년 1월 1일부터 2년 1월 1일까지이므로 365일이 될 것이다.
//            위 테스트 코드를 작성하는 순간 SubDate라는 클래스는 아직 존재하지 않는다. 
//            SubDate라는 클래스는 테스트코드에 의해서 만들어진 가상의 클래스이다. 
//            즉, 테스트 코드에 의해서 SubDate라는 클래스가 디자인되고 있는 것이다. 
//            위처럼 테스트 코드를 작성하고 저장하면 컴파일이 되지 않는다. 
		
		
		
		// --------------------------------------------- p5
		//	
//		getYearDay는 누가봐도 이상하다.
//		그래서 이번엔 실패하는 테스트 코드를 작성 
//		테스트 코드에 5년 미만의 총 일수를 구하는 테스팅 한줄.
//		assertEquals(365+365+365+366, SubDate.getYearDay(5));
		//이 테스트를 통과하려면 윤년을 체크할 수 있어야 한다.
		//		so - todo에 윤년체크가 필요하고, 윤년 체크하는 테스트 함수를 필요로 한다.
		
		

		// --------------------------------------------- p8 
		// 윤년이 제대로 체크가 되는지 한번 테스트.
		assertEquals(365+365+365+366, SubDate.getYearDay(5));
		// 정상적으로 돌아가면 윤년체크가 되는 것이다.
		// but fail이 뜰 것이고, run이 가능하게 하려면 p9로
	}
	
	
	public void testLeapYear() {
		// --------------------------------------------- p6의 테스트 코드
	    assertTrue(SubDate.isLeapYear(0));
	    assertFalse(SubDate.isLeapYear(1));
	    assertTrue(SubDate.isLeapYear(4));	    
	    //여기까지가 기본이고 100과 400에 대한 윤년의 조건을 추가한다.
	    
		// --------------------------------------------- p7의 테스트 코드
	    assertTrue(SubDate.isLeapYear(1200));
	    assertFalse(SubDate.isLeapYear(700));
	}
	
	
	
	
	
	// --------------------------------------------- p10
	// p9까지 윤년을 체크하는 로직이 끝났다.
	//이제 전 월까지의 총 일수를 구하는 로직을 만들어야 한다.
	
	//1. 두 날짜의 차이 일자를 구한다.
	//2. 특정 일자의 총 일수를 구한다.
//			2-1 전년도까지의 총 일수를 구한다.
//				2-1-1 윤년 체크.
//		>	2-2 전월까지의 총 일수를 구한다.
//			2-3 해당일자까지의 총 일수를 구한다.
	
//	public void testGetMonthDay() {
//	    assertEquals(0, SubDate.getMonthDay(1));
//	    assertEquals(31, SubDate.getMonthDay(2));
//	}
// 테스트를 위해 만들고,이제 테스트를 통과하기 위한 getMonthDay를 subDate에 만들어준다.
	
	
	
	
	// --------------------------------------------- p12	
	// 전 월까지 총 일수를 구하려면 2월이 윤년인지 아닌지 알아야지 가능하다.
	// 그럼 이제 테스트 코드에 윤달 부분을 테스트할 수 있도록 추가해 보자.
	// isLeapYear을 이용하여 그게 true면 윤년 false면 평년으로 생각하고 만들것이다.
	
	//getMonthDay에 평년을 넣었을 때 값이 (31+28)과 같은지
	//getMonthDay에 평년을 넣었을 때 값이 (31+29)와 같은지 테스트를 한다.
	public void testGetMonthDay() {
		assertEquals(31+28, SubDate.getMonthDay(3, false));
		assertEquals(31+29, SubDate.getMonthDay(3, true));
	}
	
	
	
	// --------------------------------------------- p14
	//1. 두 날짜의 차이 일자를 구한다.
	//2. 특정 일자의 총 일수를 구한다.
//			2-1 전년도까지의 총 일수를 구한다.
//				2-1-1 윤년 체크.
//			2-2 전월까지의 총 일수를 구한다.
//		>	2-3 해당일자까지의 총 일수를 구한다.
	
	//1년 1월 1일의 총 일수는 1일이 될 것이고, 
	//2년 1월 1일까지의 총 일수는 366일이 되어야 한다.
	public void testGetTotalDay() {
	    assertEquals(1, SubDate.getTotalDay("00010101"));
	    assertEquals(366, SubDate.getTotalDay("00020101"));
	}
	
	
	
	// --------------------------------------------- p15
	//>	1. 두 날짜의 차이 일자를 구한다.
	//2. 특정 일자의 총 일수를 구한다.
//			2-1 전년도까지의 총 일수를 구한다.
//				2-1-1 윤년 체크.
//			2-2 전월까지의 총 일수를 구한다.
//			2-3 해당일자까지의 총 일수를 구한다.
	
	
	//두 날짜의 차이나는 일자를 구하기 위해서 특정 일자의 총 일수를 구했다.
	//이제 이 둘을 빼면 두 날짜의 차이를 구할 수 있다. 그러기위한 테스트를 만든다.
	public void testSubDate() {
	    assertEquals(1, SubDate.sub("20061231", "20070101"));
	    assertEquals(31+28+30+31+14, 
	            SubDate.sub("20070101", "20070515"));
	    assertEquals(31+29+30+31+14, 
	            SubDate.sub("20080101", "20080515"));
	}
}