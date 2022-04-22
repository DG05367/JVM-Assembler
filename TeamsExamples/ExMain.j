; --- Compilers, DEI@FEUP 2020. -----------
; File:      ex.j
; Author:    João Cardoso, 24 March 2020
; Purpose:   Multiplies two ints using additions
; ------------------------------------------------------------------------

.class public ExMain
.super java/lang/Object

;
; standard initializer
.method public <init>()V
   aload_0
   invokespecial java/lang/Object.<init>()V
   return
.end method

.method public static mult(II)I
       ; set limits used by this method
       .limit locals 4
       .limit stack 2

       iconst_0
       istore_2
       iconst_0
       istore_3
   loop:
       iload_3
       iload_1
       if_icmpge endloop
       iload_2
       iload_0
       iadd
       istore_2
       iinc 3 1
       goto loop
	   
   endloop:
       iload_2
       ireturn

.end method


.method public static main([Ljava/lang/String;)V
	.limit locals 5
    .limit stack 2
	
	iconst_3
    istore_1
    iconst_5
    istore_2
	
	iload_1
	iload_2
	invokestatic ExMain.mult(II)I
	istore_3
	   
	ldc "Result "
	iload_3   
	invokestatic io.println(Ljava/lang/String;I)V
	
	
	;
	; StringBuilder str = new StringBuilder();
	; str.append(a).append(" x ").append(b).append(" = ").append(c);
	; System.out.println(str);
		
	new java/lang/StringBuilder
	dup
	invokespecial java/lang/StringBuilder.<init>()V
	astore 4
	
	aload 4
	iload_1
	invokevirtual java/lang/StringBuilder.append(I)Ljava/lang/StringBuilder;
	
	ldc " x "
	invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
	
	iload_2
	invokevirtual java/lang/StringBuilder.append(I)Ljava/lang/StringBuilder;
	
	ldc " = "
	invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
		
	iload_3
	invokevirtual java/lang/StringBuilder.append(I)Ljava/lang/StringBuilder;
	pop
	
	getstatic java/lang/System.out Ljava/io/PrintStream;
    aload 4
	invokevirtual java/io/PrintStream.println(Ljava/lang/Object;)V
	

	return
.end method