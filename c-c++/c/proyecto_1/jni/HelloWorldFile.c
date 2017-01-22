#include <jni.h>
 #include <stdio.h>
 #include "HelloWorld.h"
  
  void createFile(const char* name, int valorFinal){
    FILE *fp;
    char str[20];
 	char str1[] = "First part";
    char str2[] = "Second part";
    char str3[] = "Third part";
    char str4[] = "Four part";
    char str5[] = "\n";
    char buf[256];
    
    snprintf(buf, sizeof buf, "%s%s%s%s", str1, str2, str3, str4);
 		
 	fp = fopen ( name, "w" ); //parametro para escritura al final y para file tipo texto
 	int valor = 0;
    
 	while(valor < valorFinal)
 	{
        sprintf(str, "%d", valor);
        snprintf(buf, sizeof buf, "%s%s%s%s%s%s", str1, str2, str3, str4, str,str5);
 		printf("%c", fputs(buf, fp));
        ++valor;
 	}
 	
 	fclose ( fp );
}
  
  
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
    
    const char *nativeString = (*env)->GetStringUTFChars(env, text, 0);

   // use your string
    createFile(nativeString, valor);

   (*env)->ReleaseStringUTFChars(env, text, nativeString);
    
   
     return;
 }
