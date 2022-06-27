import java.io.*;

public class ExMain {
	static int mult(int a, int b) {
		int r=0;
		for(int i=0; i<b; i++) r+=a;
		return r;
	}
	
	
    public static void main(String[] args) {
		int a=3, b=5;
		int c= ExMain.mult(a, b);
		
		io.println("result: ",c);
		
		
		
		System.out.println(a+" x "+b+" = "+c);
		
	}
	
	public ExMain(int a) {
	}
	public ExMain() {
	}
	
	void f1() {
		ExMain ex1 = new ExMain();
		ExMain ex2 = new ExMain(2);
	}
}
