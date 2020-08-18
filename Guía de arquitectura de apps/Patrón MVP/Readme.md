# Android con Kotlin - Arquitectura Android MVP

El patrón de arquitectura MVP mejora la arquitectura de la aplicación para aumentar la capacidad de prueba. El patrón MVP separa el modelo de datos, desde una vista hasta un presentador.

![MVP]()

### View

Contiene solo la interfaz de usuario y no contiene ninguna lógica o conocimiento de los datos que se muestran. Los componentes de vista en MVP exportan una interfaz utilizada por el presentador para manipular la vista.

### Presenter

El presentador activa la lógica de negocios y le dice a la vista cuándo actualizar. Por lo tanto, interactúa con el modelo y obtiene y transforma datos del modelo para actualizar la vista. El presentador no debería tener, si es posible, una dependencia del SDK de Android.

### Model

Contiene un proveedor de datos y el código para buscar y actualizar los datos. Esta parte de MVP actualiza la base de datos o se comunica con un servidor web.

## Consideraciones para usar el patrón de diseño MVP
  
MVP hace que sea más fácil probar la lógica de su presentador y reemplazar las dependencias. Pero usar MVP también tiene un costo, hace que el código de su aplicación sea más largo. Además, como las plantillas estándar de Android en este momento no utilizan este enfoque, no todos los desarrolladores de Android encontrarán esta estructura de código fácil de entender.



## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.