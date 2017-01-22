#include <stdio.h>
#include "functions/functions.h"

/* Declaración */
int sumar(int numero1, int numero2);
void sumar_valor(int numero); /* prototipo de la función */
void holamundo2();

int main(void)
{
	int suma = sumar(5, 3); /* ERROR, sumar no ha sido declarada aún */
	printf("La suma es: %d ", suma);
    holamundo2(); /* llamada a la función holamundo */
    holamundo(); /* llamada a la función holamundo */
    int a;
    printf ("diga un valor para a:");
    scanf("%i",&a);
    printf ("el valor es: %i\n",a);
    
    readFile("/home/steven/development/readme.txt");
    createFile("/home/steven/development/readme2.txt");

    return 0;
}

void sumar_valor(int numero)
{
	numero++; /* le sumamos 1 al numero */

	/* el valor de número recibido se aumenta en 1
	 * y se modifica dentro de la función sumar_valor()
	 */
	printf("Valor de numero dentro sumar_valor() es: %d\n", numero);
	return;
}

void holamundo2() /* Función donde se ejecuta la lógica del programa */
{
 	printf("Hola Mundo\n"); /* imprime la cadena */
	return; /* sale de la función */
}

/* Definición */
int sumar(int numero1, int numero2)
{
	return numero1 + numero2;
}
