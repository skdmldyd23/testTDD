package testTdd;

//Need	->	Test		->			Code 
//				<-	Refactoring		->

//20190701 - 20190715 = 14
//20190715 - 2019071 = 14

//윤달이 때문에 힘듬
//결과 = abs(첫 번째 날짜의 총 일수  - 두 번째 날짜의 총 일수)

//Todo
// 텍스트 필드로 값을 받는다.
// 버튼을 누르면 값을 출력한다.

// 두 날짜의 차이 일자를 구한다.		--- 1
// 특정 일자의 총 일수를 구한다.		--- 2

// 세분화하면
// 전년도까지의 총 일수를 구한다.		--- 2-1
// 전월까지의 총 일수를 구한다.		--- 2-2
// 해당일자까지의 총 일수를 구한다.	--- 2-3

//즉, 20190515라는 날짜의 총 일수를 구하고 싶다면

//2019년 5월 15일의 총 일수 = 0년부터 2019년까지의 총 일수 + 2019년 1월부터 4월까지의 총 일수 + 15

//		시작

// 1. 두 날짜의 차이 일자를 구한다.
// 2. 특정 일자의 총 일수를 구한다.
//   >	2-1 전년도까지의 총 일수를 구한다.
//		2-2 전월까지의 총 일수를 구한다.
//		2-3 해당일자까지의 총 일수를 구한다.

//subDateTest라는 테스트 케이스를 사용해서 테스트를 한다.		-p1

//--------------------------------------------- p3

//public class SubDate {
//    public static int getYearDay(int year) {
//        return 1;
//    }
//}

// 컴파일은 되지만 테스트 코드 실행 시 실패하는 것을 볼 수 있다. 
// TDD는 "테스트가 실패할 경우에만 실제코드를 작성 한다"는 간단한 법칙을 따른다.
//subDateTest가 성공을 하기 위해서 값을 지정해준다.

//---------------------------------------------- p4

public class SubDate {
	
	
	
//	public static int getYearDay(int year) {
//		if (year == 1)
//			return 0;
//		else
//			return 365;
//	}
	// 실행해도 실패하지 않는다. 이따구로 해도 돌아는 간다. 테스트를 통과만 하면 된다.
	// TDD싸이클에 의해 결국에는 당연한 코드로 변경되기 때문이다.
	// 이제 다시 실패하는 테스트 코드를 작성할 차례 subDateTest로 

	
	
	// --------------------------------------------- p6
	//1. 두 날짜의 차이 일자를 구한다.
	//2. 특정 일자의 총 일수를 구한다.
//		>	2-1 전년도까지의 총 일수를 구한다.
//			>	2-1-1 윤년 체크.
//			2-2 전월까지의 총 일수를 구한다.
//			2-3 해당일자까지의 총 일수를 구한다.

	//public static boolean isLeapYear(int year) {
//	    if (year == 0) return true;
//	    if (year == 1) return false;
//	    if (year == 4) return true;
//	    return false;
	//}

	// --------------------------------------------- p7
	//위의 함수를 보면 0과 4에서 true so,리팩토링을 통하여 코드를 좀 더 간단하게 만든다

	//public static boolean isLeapYear(int year) {
//		if(year%4 == 0) return true;
//		return false;
	//}
	// 여기서 윤년의 조건을 보고 좀 더 디테일하게 구현한다.


	// 윤년의 기준


	//서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고,
	//그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며,
	//다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.

	//위의 3가지가 윤년의 기준이고 우선 순위는 400, 100(평년 false), 4 순서이다.
	//so, 조건문을 400 100 4 순으로 만들고 return을 구현해준다.

	public static boolean isLeapYear(int year) {
		if(year%400 == 0) return true;
		if(year%100 == 0) return false;
		if(year%4 == 0) return true;
		return false;
	}
	
	
	

	// --------------------------------------------- p9
	// 윤년 체크하는 로직을 윤년인지 아닌지 체크하고, 값을 더해준다.
	public static int getYearDay(int year) {
	    int result = 0;
	    for (int i=1; i < year; i++) {
	        if (isLeapYear(i)) result += 366;
	        else result += 365;
	    }
	    return result;
	}
	

	// --------------------------------------------- p11
	// p9까지 윤년을 체크하는 로직이 끝났다.
	//이제 전 월까지의 총 일수를 구하는 로직을 만들어야 한다.
	
	//1. 두 날짜의 차이 일자를 구한다.
	//2. 특정 일자의 총 일수를 구한다.
//			2-1 전년도까지의 총 일수를 구한다.
//				2-1-1 윤년 체크.
//		>	2-2 전월까지의 총 일수를 구한다.
//			2-3 해당일자까지의 총 일수를 구한다.
	
//	public static int getMonthDay(int month) {
//	    if (month == 1) return 0;
//	    else return 31;
//	}
	
	
	
	

	// --------------------------------------------- p13
	//달을 입력받고,그 달이 2월보다 크고, 윤년이면
	//결과값에 +1을 해주고 아니면 그냥 통과한다.
	
	static int[] monthDays = {
		    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		public static int getMonthDay(int month, boolean isLeap) {
		    int result = 0;
		    for(int i=1; i< month; i++) {
		        result += monthDays[i-1];
		    }

		    if (isLeap && month > 2) result += 1;
		    return result;
		}
		
	//이러면 이전 달까지의 값을 더해주는 로직이 완성된다.

		
		
		// --------------------------------------------- p15
		//		>	2-2 전월까지의 총 일수를 구한다.
		//올해 이전의 year까지가 몇일인지 구하는 getYearDay에 입력받는 date의 년도를 넣고,
		//원하는 달의 이전 달까지가 구하는 getYearDay에 입력받는 date의 년도를 넣고,
		//원하는 날을 넣어준다.
		public static int getTotalDay(String date) {
		    int year = Integer.parseInt(date.substring(0, 4));
		    int month = Integer.parseInt(date.substring(4, 6));
		    int day = Integer.parseInt(date.substring(6, 8));
		    return getYearDay(year)
		        + getMonthDay(month, isLeapYear(year))
		        + day;
		}
		
		
		// --------------------------------------------- p17
		// 총 몇일인지를 구했기 때문에 두 값을 받아와서 빼기만 하면 된다.
		public static int sub(String date1, String date2) {
		    return Math.abs(getTotalDay(date1) - getTotalDay(date2));
		}

}




