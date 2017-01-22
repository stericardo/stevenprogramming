#include "functions.h"
#include <stdio.h>
#include <stdlib.h> 
//Functions
void global(void){
 
}

void holamundo(void) /* Función donde se ejecuta la lógica del programa */
{
 	printf("Hola Mundo reuse function"); /* imprime la cadena */
	return; /* sale de la función */
}

void readFile(char* name){
    
    FILE *archivo;
	char caracter;
	
	archivo = fopen(name,"r");
	
	if (archivo == NULL)
        {
            printf("\nError de apertura del archivo. \n\n");
        }
        else
        {
            printf("\nEl contenido del archivo de prueba es \n\n");
            while (feof(archivo) == 0)
            {
                    caracter = fgetc(archivo);
            printf("%c",caracter);
            }
        }
        fclose(archivo);
}

void createFile(char* name){
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
    
 	while(valor < 20)
 	{
        sprintf(str, "%d", valor);
        snprintf(buf, sizeof buf, "%s%s%s%s%s%s", str1, str2, str3, str4, str,str5);
 		printf("%c", fputs(buf, fp));
        ++valor;
 	}
 	
 	fclose ( fp );
}
