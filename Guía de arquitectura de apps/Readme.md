# Android con Kotlin - Guía de arquitectura de apps

La guía de arquitectura de apps de Jetpack brinda una descripción general de las prácticas y la arquitectura que se recomienda tener en cuenta al crear una app para Android.

Una app para Android típica consta de varios componentes, como actividades, fragmentos, servicios, proveedores de contenido y receptores de emisión. 

A la mayoría de estos componentes los declaras en el manifiesto de la app. Luego, el SO Android usa ese archivo para decidir cómo integrar tu app a la experiencia del usuario general del dispositivo.

## Principios de arquitectura

### Separación de problemas

Un error común es escribir todo tu código en una Activity o un Fragment. Estas clases basadas en IU solo deberían contener lógica que se ocupe de interacciones del sistema operativo y de IU.<br/>
Mantener estas clases limpias puede evitar muchos problemas relacionados con el ciclo de vida. Reducir la dependencia de estas clases para que puedas brindar una experiencia del usuario satisfactoria y una experiencia de mantenimiento más fácil de administrar.

### Controlar la IU a partir de un modelo

Los modelos son componentes responsables de administrar los datos de una app. Son independientes de los componentes de la app y los objetos View, de modo que no se ven afectados por el ciclo de vida de la app y los problemas asociados.

El modelo de persistencia es ideal debido a los siguientes motivos:

* Los usuarios no perderán datos si el SO Android cierra tu app para liberar recursos.
* La app continuará funcionando cuando la conexión de red sea inestable o no esté disponible.

Si una app está basada en clases de modelos con una responsabilidad bien definida para la administración de datos, tu app será más consistente y será más fácil realizar pruebas en ella.


## Arquitectura de app recomendada

![Arquitectura de app recomendada](https://github.com/arbems/Android-with-Kotlin-App-Architecture/blob/master/Gu%C3%ADa%20de%20arquitectura%20de%20apps/0001.png?raw=true)
<img width="800" src="">

Este diseño crea una experiencia del usuario consistente y agradable. Independientemente de que el usuario vuelva a la app varios minutos después de cerrarla por última vez o varios días más tarde, verá al instante la información del usuario de que la app persiste a nivel local. Si estos datos están inactivos, el módulo de repositorio comienza a actualizar los datos en segundo plano.

`Nota: Es imposible que una única forma de escribir el código sea la mejor para todas las situaciones. Ahora bien, esta arquitectura recomendada es un buen punto de partida para la mayoría de las situaciones y los flujos de trabajo.`

Cada componente solo depende del componente que está un nivel más abajo, excepto el repositorio.

### **Actividad o fragmento**

La IU consta de un fragmento o actividad y su archivo de diseño correspondiente. 

Las actividades y los fragmentos solo dependen de un ViewModel.

\* **DataBinding**

### **ViewModel**

Un objeto ViewModel proporciona los datos para un componente de IU específico, como un fragmento o una actividad, y también incluye lógica empresarial de manejo de datos para comunicarse con el modelo. ViewModel no conoce los componentes de IU, de manera que no se ve afectado por los cambios de configuración, como la recreación de una actividad debido a la rotación del dispositivo.

Dado que se espera que los objetos ViewModel duren más que los objetos View correspondientes que se actualizan, no debes incluir referencias directas a objetos View dentro de tu implementación de ViewModel. 

Si necesitas acceder a argumentos del fragmento o actividad puedes usar el módulo SavedState para que nuestro ViewModel lea el argumento directamente. **SavedStateHandle** permite que ViewModel acceda al estado y los argumentos guardados del fragmento o actividad asociados.

`Nota: SavedStateHandle permite que ViewModel acceda al estado y los argumentos guardados del fragmento o actividad asociados.`

\* **LiveData**

LiveData es una clase que retiene datos observables. Otros componentes de tu app pueden supervisar cambios en objetos que usan LiveData sin crear rutas de dependencia explícitas y rígidas entre ellos. El componente LiveData también respeta el estado del ciclo de vida de los componentes de tu app, como las actividades, los fragmentos y los servicios, e incluye lógica de limpieza para evitar las fugas de objetos y el consumo de memoria excesivo.

`Nota: Si ya estás usando una biblioteca como RxJava, puedes continuar usándola en lugar de LiveData.`

### **Repositorio**

El repositorio abstrae las fuentes de datos del resto de la app, podemos proporcionarle la información de varias implementaciones de obtención de datos diferentes.

El repositorio es la única clase que depende de otras clases, el repositorio depende de un modelo de datos persistente y de una fuente de datos de backend remota.

Una idea inicial para implementar ViewModel podría consistir en llamar directamente a la fuente de datos a fin de obtener los datos y asignarlos a nuestro objeto LiveData. Aunque este método funciona, el mantenimiento de nuestra app se complica a medida que crece.

Asigna demasiada responsabilidad a la clase ViewModel, lo que infringe el principio de separación de problemas.

Además, el alcance de un ViewModel está vinculado a un ciclo de vida de Activity o Fragment, lo que significa que los datos de la fuente de datos se pierden cuando finaliza el ciclo de vida del objeto de IU asociado.

Por esto ViewModel delega el proceso de obtención de datos a un nuevo módulo, un *repositorio*.

Los módulos de *repositorio* manejan las operaciones de datos. Proporcionan una API limpia para que el resto de la app pueda recuperar estos datos fácilmente.

Saben de dónde obtener los datos y qué llamadas de API deben hacer cuando se actualizan los datos. Puedes considerar a los repositorios como mediadores entre diferentes fuentes de datos, como *modelos persistentes*, *servicios web* y *memorias caché*.

### Fuentes de datos
#### 1. **Modelo**
\* **Room**

\* **SQLite**

#### 2. **Fuente de datos remota**
\* [**Retrofit**](https://square.github.io/retrofit/) biblioteca para acceder a nuestro backend.

\* **WebServices**


## Enlaces

[**Github Dagger**](https://github.com/google/dagger/releases)

[**Github Retrofit**](https://square.github.io/retrofit/)

[**Room**]()


## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.