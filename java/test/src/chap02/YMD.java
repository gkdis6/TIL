package chap02;

import java.util.Scanner;

public class YMD {
	int y, m, d;
	
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} //윤
	};
	
	static int isLeap(int year) {
		return(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? 1 : 0;
	}
	
	YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	YMD after(int n) {
		YMD ymd = new YMD(this.y, this.m, this.d);
		if(n<0)
			return before(-n);
		ymd.d += n;
		
		if(ymd.d <= mdays[isLeap(ymd.y)][ymd.m-1]) {
			return ymd;
		}else {
			for(int i = ymd.y; ymd.d>mdays[isLeap(ymd.y)][ymd.m-1]; i++) {
				ymd.d -= mdays[isLeap(ymd.y)][ymd.m-1];
				ymd.m++;
				if(ymd.m == 12) {
					ymd.y++;
					ymd.m = 1;
				}
			}
			
		}
		return ymd;
	}
	
	YMD before(int n) {
		YMD ymd = new YMD(this.y, this.m, this.d);
		if(n<0)
			return after(-n);
		ymd.d -= n;
		
		if(ymd.d >0) {
			return ymd;
		}else {
			for(int i = ymd.y; ymd.d<1; i--) {
				ymd.m--;
				ymd.d += mdays[isLeap(ymd.y)][ymd.m-1];
				if(ymd.m == 1) {
					ymd.y--;
					ymd.m = 12;
				}
			}
			
		}
		return ymd;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년：");
		int y = in.nextInt();
		System.out.print("월：");
		int m = in.nextInt();
		System.out.print("일：");
		int d = in.nextInt();
		YMD ymd = new YMD(y, m, d);

		System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
		int n = in.nextInt();
		
		YMD d1 = ymd.after(n);
		YMD d2 = ymd.before(n);
		System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일 입니다.\n", n, d1.y, d1.m, d1.d);
		System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일 입니다.", n, d2.y, d2.m, d2.d);
		
	}
	
	
	
	
	
	

}
