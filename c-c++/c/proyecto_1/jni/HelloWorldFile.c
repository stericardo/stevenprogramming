#include <jni.h>
 #include <stdio.h>
 #include "HelloWorld.h"
  
 JNIEXPORT void JNICALL 
 Java_HelloWorldFile_print(JNIEnv *env, jobject obj, jint valor, jstring text)
 {
     printf("Hello World ccccccccc!\n");
     printf("Hello valor %d\n", valor);
     printf("Hello text %s\n", text);
     printf("\n");
     
     const jbyte *str;
    str = (*env)->GetStringUTFChars(env, text, NULL); //1
    printf("Hello %s\n", str);
    (*env)->ReleaseStringUTFChars(env, text, str); //2
     return;
 }
