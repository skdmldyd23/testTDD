package testTdd;

//Need	->	Test		->			Code 
//				<-	Refactoring		->

//20190701 - 20190715 = 14
//20190715 - 2019071 = 14

//������ ������ ����
//��� = abs(ù ��° ��¥�� �� �ϼ�  - �� ��° ��¥�� �� �ϼ�)

//Todo
// �ؽ�Ʈ �ʵ�� ���� �޴´�.
// ��ư�� ������ ���� ����Ѵ�.

// �� ��¥�� ���� ���ڸ� ���Ѵ�.		--- 1
// Ư�� ������ �� �ϼ��� ���Ѵ�.		--- 2

// ����ȭ�ϸ�
// ���⵵������ �� �ϼ��� ���Ѵ�.		--- 2-1
// ���������� �� �ϼ��� ���Ѵ�.		--- 2-2
// �ش����ڱ����� �� �ϼ��� ���Ѵ�.	--- 2-3

//��, 20190515��� ��¥�� �� �ϼ��� ���ϰ� �ʹٸ�

//2019�� 5�� 15���� �� �ϼ� = 0����� 2019������� �� �ϼ� + 2019�� 1������ 4�������� �� �ϼ� + 15

//		����

// 1. �� ��¥�� ���� ���ڸ� ���Ѵ�.
// 2. Ư�� ������ �� �ϼ��� ���Ѵ�.
//   >	2-1 ���⵵������ �� �ϼ��� ���Ѵ�.
//		2-2 ���������� �� �ϼ��� ���Ѵ�.
//		2-3 �ش����ڱ����� �� �ϼ��� ���Ѵ�.

//subDateTest��� �׽�Ʈ ���̽��� ����ؼ� �׽�Ʈ�� �Ѵ�.		-p1

//--------------------------------------------- p3

//public class SubDate {
//    public static int getYearDay(int year) {
//        return 1;
//    }
//}

// �������� ������ �׽�Ʈ �ڵ� ���� �� �����ϴ� ���� �� �� �ִ�. 
// TDD�� "�׽�Ʈ�� ������ ��쿡�� �����ڵ带 �ۼ� �Ѵ�"�� ������ ��Ģ�� ������.
//subDateTest�� ������ �ϱ� ���ؼ� ���� �������ش�.

//---------------------------------------------- p4

public class SubDate {
	
	
	
//	public static int getYearDay(int year) {
//		if (year == 1)
//			return 0;
//		else
//			return 365;
//	}
	// �����ص� �������� �ʴ´�. �̵����� �ص� ���ƴ� ����. �׽�Ʈ�� ����� �ϸ� �ȴ�.
	// TDD����Ŭ�� ���� �ᱹ���� �翬�� �ڵ�� ����Ǳ� �����̴�.
	// ���� �ٽ� �����ϴ� �׽�Ʈ �ڵ带 �ۼ��� ���� subDateTest�� 

	
	
	// --------------------------------------------- p6
	//1. �� ��¥�� ���� ���ڸ� ���Ѵ�.
	//2. Ư�� ������ �� �ϼ��� ���Ѵ�.
//		>	2-1 ���⵵������ �� �ϼ��� ���Ѵ�.
//			>	2-1-1 ���� üũ.
//			2-2 ���������� �� �ϼ��� ���Ѵ�.
//			2-3 �ش����ڱ����� �� �ϼ��� ���Ѵ�.

	//public static boolean isLeapYear(int year) {
//	    if (year == 0) return true;
//	    if (year == 1) return false;
//	    if (year == 4) return true;
//	    return false;
	//}

	// --------------------------------------------- p7
	//���� �Լ��� ���� 0�� 4���� true so,�����丵�� ���Ͽ� �ڵ带 �� �� �����ϰ� �����

	//public static boolean isLeapYear(int year) {
//		if(year%4 == 0) return true;
//		return false;
	//}
	// ���⼭ ������ ������ ���� �� �� �������ϰ� �����Ѵ�.


	// ������ ����


	//���� ��� ������ 4�� ������ �������� �ش� �켱 �������� �ϰ�,
	//�� �߿��� 100���� ������ �������� �ش� ������� �ϸ�,
	//�ٸ� 400���� ������ �������� �ش� �ٽ� �������� ���Ͽ���.

	//���� 3������ ������ �����̰� �켱 ������ 400, 100(��� false), 4 �����̴�.
	//so, ���ǹ��� 400 100 4 ������ ����� return�� �������ش�.

	public static boolean isLeapYear(int year) {
		if(year%400 == 0) return true;
		if(year%100 == 0) return false;
		if(year%4 == 0) return true;
		return false;
	}
	
	
	

	// --------------------------------------------- p9
	// ���� üũ�ϴ� ������ �������� �ƴ��� üũ�ϰ�, ���� �����ش�.
	public static int getYearDay(int year) {
	    int result = 0;
	    for (int i=1; i < year; i++) {
	        if (isLeapYear(i)) result += 366;
	        else result += 365;
	    }
	    return result;
	}
	

	// --------------------------------------------- p11
	// p9���� ������ üũ�ϴ� ������ ������.
	//���� �� �������� �� �ϼ��� ���ϴ� ������ ������ �Ѵ�.
	
	//1. �� ��¥�� ���� ���ڸ� ���Ѵ�.
	//2. Ư�� ������ �� �ϼ��� ���Ѵ�.
//			2-1 ���⵵������ �� �ϼ��� ���Ѵ�.
//				2-1-1 ���� üũ.
//		>	2-2 ���������� �� �ϼ��� ���Ѵ�.
//			2-3 �ش����ڱ����� �� �ϼ��� ���Ѵ�.
	
//	public static int getMonthDay(int month) {
//	    if (month == 1) return 0;
//	    else return 31;
//	}
	
	
	
	

	// --------------------------------------------- p13
	//���� �Է¹ް�,�� ���� 2������ ũ��, �����̸�
	//������� +1�� ���ְ� �ƴϸ� �׳� ����Ѵ�.
	
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
		
	//�̷��� ���� �ޱ����� ���� �����ִ� ������ �ϼ��ȴ�.

		
		
		// --------------------------------------------- p15
		//		>	2-2 ���������� �� �ϼ��� ���Ѵ�.
		//���� ������ year������ �������� ���ϴ� getYearDay�� �Է¹޴� date�� �⵵�� �ְ�,
		//���ϴ� ���� ���� �ޱ����� ���ϴ� getYearDay�� �Է¹޴� date�� �⵵�� �ְ�,
		//���ϴ� ���� �־��ش�.
		public static int getTotalDay(String date) {
		    int year = Integer.parseInt(date.substring(0, 4));
		    int month = Integer.parseInt(date.substring(4, 6));
		    int day = Integer.parseInt(date.substring(6, 8));
		    return getYearDay(year)
		        + getMonthDay(month, isLeapYear(year))
		        + day;
		}
		
		
		// --------------------------------------------- p17
		// �� ���������� ���߱� ������ �� ���� �޾ƿͼ� ���⸸ �ϸ� �ȴ�.
		public static int sub(String date1, String date2) {
		    return Math.abs(getTotalDay(date1) - getTotalDay(date2));
		}

}



