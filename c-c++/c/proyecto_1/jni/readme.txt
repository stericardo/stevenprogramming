https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html

1) javac HelloJNI.java
2) javah HelloJNI
3) create HelloJNI.c 
4 y 5 tal vez no son requeridos si estan todo bien seteados
4) set JAVA_HOME=/cygdrive/c/Program Files/Java/jdk1.8.0_91
5) echo %JAVA_HOME% 
6) En cywing del 3 pase a este paso:
gcc -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hello.dll HelloJNI.c

Linux Funcionando:
 
 
gcc -shared -fpic -o libhello.so -I"/usr/java/jdk1.8.0_91/include" -I"/usr/java/jdk1.8.0_91/include/linux" HelloJNI.c
java -Djava.library.path=. HelloJNI


gcc -shared -fpic -I"/usr/java/jdk1.8.0_91/include" -I"/usr/java/jdk1.8.0_91/include/linux" HelloWorld.c -o libHelloWorld.so
java -Djava.library.path=. HelloWorld
 
7)nm hello.dll | grep say
You can see something like that: 624011d8 T _Java_HelloJNI_sayHello@8
8) java HelloJNI
java.lang.UnsatisfiedLinkError: C:\cygwin\home\steven.mendez\development\c-c++\jni\hello.dll: Can't load IA 32-bit .dll on a AMD 64-bit platform
Se debe compilar con cualquier version del JDK pero se debe correr con el JRE 32 bits


Then solution:



/cygdrive/c/cygwin/home/steven.mendez/development/c-c++/jni
