.class public ex
.super java

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
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
