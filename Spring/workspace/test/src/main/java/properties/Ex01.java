package properties;

import java.util.*;

public class Ex01 {

	public static void main(String[] args) {

		Scanner r = new Scanner(System.in);
		System.out.print("파일명을 입력하세요. : ");
		String file = r.nextLine();
		System.out.println();

		while (file.startsWith(".")||file.endsWith(".")|| (file.indexOf(".") == -1)) {
			System.out.print("잘못 입력되었습니다. 다시 입력해주세요 : ");
			file = r.nextLine();
		}
		int index = file.lastIndexOf(".");
		System.out.println("파일명은 "+file.substring(0, index)+" 입니다.");
		System.out.println("파일의 확장자는 "+file.substring(index+1)+" 입니다.");
		
		
//		while(true) {
//			while(file.startsWith(".")||file.endsWith(".")|| (file.indexOf(".") == -1)){
//				System.out.print("잘못 입력되었습니다. 다시 입력해주세요 : ");
//				file = r.nextLine();
//			}
//			int index = file.lastIndexOf(".");
//			System.out.println("파일명은 "+file.substring(0, index)+" 입니다.");
//			System.out.println("파일의 확장자는 "+file.substring(index+1)+" 입니다.");
//			break;
//		}
	}

}
