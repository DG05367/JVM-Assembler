; --- Compilers, DEI@FEUP 2020. -----------
; File:      ex.j
; Author:    João Cardoso, 24 March 2020
; Purpose:   Multiplies two ints using additions
; ------------------------------------------------------------------------

.class public ex1
.super java/lang/Object

;
; standard initializer
.method public <init>()V
   aload_0
   invokespecial java/lang/Object/<init>()V
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

.method public static f2(II)I
       ; set limits used by this method
       .limit locals 2
       .limit stack 3

		new ex1        ;  #3                  // class ex1
       ;dup
       ;invokespecial "<init>":()V
       astore_1
       
	   ;aload_1
       ;bipush        10
		bipush        20
      ;invokevirtual mult:(II)I ; #2                  // Method mult:(II)I
      ireturn

.end method
