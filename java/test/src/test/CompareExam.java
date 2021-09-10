package test;

public class CompareExam {

	public static void exec(Compare compare) {
		int k = 10;
		int m = 20;
		int value = compare.compareTo(k,m);
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		exec((i,j) -> {
			return i-j;
		});
		
		String str = "dksdafe!$#%";
		String[] str2 = str.split("");
		for (String string : str2) {
			System.out.println(string);
		}
		switch (key) {
		case value: {
			
			yield type;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

}


