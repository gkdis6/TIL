package day07_coding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class DevProcess {

	public static void main(String[] args) {
		String fileName = "/Users/sangyongpark/eclipse-workspace/test/dev.txt";
		String fileNameOutput = "/Users/sangyongpark/eclipse-workspace/test/dev_output.txt";

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(fileNameOutput, false);
			PrintWriter pw = new PrintWriter(fw);

			String line = "";

			pw.println("        2019년 신입사원 평가 점수 ");
			pw.println("");
			pw.println("평가일: " + new Date().toLocaleString());
			pw.println("--------------------------------------------");
			pw.println("성  명  JAVA  JSP  SPRING  PROJECT  TOT  AVG");
			pw.println("--------------------------------------------");
			while (true) {
				line = br.readLine(); // 한라인씩 읽어옴.

				if (line == null) {
					break;
				}
				String[] str = line.split(",");
        System.out.println(str[0]); 
        System.out.println(str[1]); 
        System.out.println(str[2]); 
        System.out.println(str[3]); 
        System.out.println(str[4]); 
				String name = str[0];
				int java = Integer.parseInt(str[1]);
				int jsp = Integer.parseInt(str[2]);
				int spring = Integer.parseInt(str[3]);
				int project = Integer.parseInt(str[4]);

				int tot = java + jsp + spring + project;
				int avg = tot / 4;
				pw.println(name + "   " + java + "   " + jsp + "    " + spring + "     " + project + "      " + tot
						+ "   " + avg);
				pw.println("--------------------------------------------");
			}
			pw.println("         SOLDESK IT Academy 2019        ");

			br.close();
			fr.close();

			pw.flush();
			pw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}