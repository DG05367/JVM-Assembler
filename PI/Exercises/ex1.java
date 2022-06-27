public class ex1 {
	int mult(int a, int b) {
		int r=0;
		for(int i=0; i<b; i++) r+=a;
		return r;
	}
	
	int f1() {
		return mult(10, 20);
	}
	
	/*
	 int f2();
    Code:
       0: new           #3                  // class ex1
       3: dup
       4: invokespecial #4                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: bipush        10
      11: bipush        20
      13: invokevirtual #2                  // Method mult:(II)I
      16: ireturn
	  
	  int f2();
    Code:
       new           #3                  // class ex1
	   astore_1  // store in local variable 1 the reference A (instance of ex1)
	   
	   aload_1
	   invokespecial #4                  // Method "<init>":()V
	   
	   aload_1
       bipush        10
       bipush        20
       invokevirtual #2                  // Method mult:(II)I
       ireturn 
	  
	  
	*/
	int f2() {
		ex1 A = new ex1();
		return A.mult(10, 20);
	}
}
