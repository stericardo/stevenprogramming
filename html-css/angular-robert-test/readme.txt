Buenos días Steven,

Adjunto proyecto base para el assessment, para instalarlo seguir los siguientes pasos:
* Descomprimir el archivo angular-assessment.zip en el folder de su preferencia.
* Una vez descomprimido abren la consola y se van a la ruta donde descomprimieron el proyecto y corren el comando npm install.
* Una vez que termine de instalar todas las dependencias, se corre la tarea de gulp serve.

También te adjunto los wireframes de como se espera que luzcan las páginas.



Descripción:

Index.html:
Crear un SPA (Single Page Application) que actualice el contenido, utilizando tres vistas, (home, products, detail), cada vista se debe manejarse 
como una ruta independiente. El header debe ser compartido en la página, utilizar un componente navbar (bootstrap).


View Homepage:
Ruta: #/
Esta vista muestra un componente jumbotron (bootstrap), con información.


View Products:
Ruta: #/products
Esta vista debe contener un Angular Controller (ProductsController).


View Details:
Ruta: #/products/details/:id
Esta vista debe mostrar el detalle del producto, debe contener un Angular Controller (DetailController).


Module myApp
Crear un módulo para la aplicación. 


Module myApp.products:
Crear un módulo para la funcionalidad de productos, este contiene el Angular Factory productsService y los Angular Controllers ProductsController 
y DetailController.


Service: productsService
Crear un Angular Factory (productsService) el cual debe exponer dos métodos (getProduct, getProducts). 
* getProducts: debe retornar toda la lista de productos.
* getProduct: debe recibir el id del producto y solo retornar el producto con el id correspondiente.
* El servicio debe retornar una promesa la cual se resuelve si el request se ejecuta correctamente o debe ser rejectada y mostrar 
un mensaje de  error con el servicio de $log si falla, el servicio debe utilizar los servicios de angular $http, $q y $log.


Controller ProductsController:
Este se encarga de la funcionalidad para la vista de productos, esta debe mostrar una lista con los productos la información se obtiene 
de un JSON, esta información se debe obtener por medio de un servicio (productsService) y el método getProducts.
La lista debe mostrar el id, phone name y company y un boton de mostrar details por cada producto.


Controller DetailController:
Este se encarga de la funcionalidad para la vista de detail, esta debe mostrar el detalle del producto, su título, la imagen y dentro de 
un componente well (bootstrap) la descripción del producto, además de un boton de Go Products que nos permita retornar a la vista de productos. 
La información se obtiene de un JSON, esta información se debe obtener por medio de un servicio (productsService) y el método getProduct 
el cual debe recibir el id del producto.
En caso de no existir el producto, la vista debe re direccionar a la vista products.


Module myApp.common:
Crear un módulo para la funcionalidad compartida, este contiene los Angular Directive backToTop.


Directive backToTop:
Implementar una directiva de tipo elemento que realice la funcionalidad de un back to top.
Crear los estilos necesarios.
http://jsfiddle.net/gilbitron/Lt2wH/


Puntos extras:  
* Optimizar la lista para reducir el número de watchers.
* Incorporar un loading mientras se carga la lista de productos utilizando Font Awesome.



Suerte, cualquier duda me preguntan.
