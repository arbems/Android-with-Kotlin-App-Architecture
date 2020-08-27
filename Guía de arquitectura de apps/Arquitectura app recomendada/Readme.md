# Android con Kotlin - Modern Android Architecture

A medida que el software comienza a crecer y a hacerse más complejo, es importante que tenga una forma bien definida para facilitar su mantenimiento y su crecimiento en el futuro. La arquitectura del software define la estructura que debe de tener una app, los componentes que debemos construir y como van a interactuar entre ellos.

El mantenimiento es esencial, porque aunque un software se pueda desarrollar en unas pocas semanas o meses, lo más probable es que se mantenga durante años, añadiendo nuevas funcionalidades requeridas, o corrigiendo problemas existentes. El crecimiento también es fundamental, porque todo software cuya funcionalidad no se amplíe o se modifique, tiende a ser inservible en un relativamente corto espacio de tiempo.

Esta es la arquitectura de app recomendada por Android, es imposible que una única forma de escribir el código sea la mejor para todas las situaciones. Ahora bien, esta arquitectura recomendada es un buen punto de partida para la mayoría de las situaciones y los flujos de trabajo.

Este diseño crea una experiencia del usuario consistente y agradable. Independientemente de que el usuario vuelva a la app varios minutos después de cerrarla por última vez o varios días más tarde, verá al instante la información del usuario de que la app persiste a nivel local. Si estos datos están inactivos, el módulo de repositorio comienza a actualizar los datos en segundo plano.

Cada componente solo depende del componente que está un nivel más abajo:
* Las actividades y los fragmentos solo dependen de un modelo de vista. 
* El modelo de vista depende de un repositorio
* El repositorio depende de un modelo de datos persistente y de una fuente de datos de backend remota.

<img src="https://raw.githubusercontent.com/arbems/Android-with-Kotlin-App-Architecture/master/Gu%C3%ADa%20de%20arquitectura%20de%20apps/0001.png" width="700">

## Los principios de arquitectura

#### Separación de problemas

Un error común es escribir todo tu código en una Activity o un Fragment. Estas clases basadas en IU solo deberían contener lógica que se ocupe de interacciones del sistema operativo y de IU.<br/>
Mantener estas clases limpias puede evitar muchos problemas relacionados con el ciclo de vida. Reducir la dependencia de estas clases para que puedas brindar una experiencia del usuario satisfactoria y una experiencia de mantenimiento más fácil de administrar.

#### Controlar la IU a partir de un modelo

Los modelos son componentes responsables de administrar los datos de una app. Son independientes de los componentes de la app y los objetos View, de modo que no se ven afectados por el ciclo de vida de la app y los problemas asociados.

El modelo de persistencia es ideal debido a los siguientes motivos:

* Los usuarios no perderán datos si el SO Android cierra tu app para liberar recursos.
* La app continuará funcionando cuando la conexión de red sea inestable o no esté disponible.

Si una app está basada en clases de modelos con una responsabilidad bien definida para la administración de datos, tu app será más consistente y será más fácil realizar pruebas en ella.


## Interfaz de usuario

Los controladores de IU, como las actividades y los fragmentos, tienen como objetivo principal mostrar datos de IU, reaccionar a las acciones de los usuarios o administrar la comunicación del sistema operativo, como las solicitudes de permisos. Si se establece que los controladores de IU también sean responsables de cargar datos de una red o base de datos, la clase estará sobrecargada. Asignar demasiadas responsabilidades a los controladores de IU puede provocar que una sola clase trate de administrar todo el trabajo de una app por su cuenta, en lugar de delegar el trabajo a otras clases. Si asignas demasiadas responsabilidades a los controladores de IU de este modo, será mucho más difícil realizar las pruebas.
Es más fácil y eficiente separar la propiedad de los datos de visualización de la lógica del controlador de IU.

* Creamos la UI que consta de fragment (*UserProfileFragment*), es el controlador de IU que controla los datos.
* Archivo de diseño correspondiente (*user_profile.xml*).
* Usamos un **ViewModel** (*UserProfileViewModel*) basado en el componente de arquitectura con el mismo nombre. Es la clase que prepara los datos para su visualización en Fragment y reacciona a las interacciones del usuario.
* Para acceder desde el ViewModel a los argumentos del fragmento podemos usar el módulo SavedState para que el ViewModel lea el argumento directamente. **SavedStateHandle** permite que ViewModel acceda al estado y los argumentos guardados del fragmento o actividad asociados.
    * No necesitamos manejar los cambios de configuración, ViewModel se restaura de manera automática cuando cambia la configuración.
    * No debes incluir referencias directas a objetos View dentro de tu implementación de ViewModel.
* Ahora debemos informarle a nuestro fragmento cuándo se obtiene el objeto del usuario. En ese momento, entra en juego el componente **LiveData** que es una clase que retiene datos observables. Otros componentes de tu app pueden supervisar cambios en objetos que usan este titular sin crear rutas de dependencia explícitas y rígidas entre ellos. El componente LiveData también respeta el estado del ciclo de vida de los componentes de tu app, como las actividades, los fragmentos y los servicios, e incluye lógica de limpieza para evitar las fugas de objetos y el consumo de memoria excesivo.
    * LiveData también quita automáticamente el observador cuando se llama al método onDestroy() de un fragmento.
* Ahora modificamos *UserProfileFragment* para observar los datos y actualizar la IU. Cada vez que se actualicen los datos del perfil de usuario, se invocará la devolución de llamada onChanged() y se actualizará la IU.

### DataBinding

## Obtener los datos



## Conectar ViewModel y el repositorio

## Datos caché

## Conservar los datos

## Mostrar operaciones en curso

## Probar cada componente






## Activity o fragment (View)

La IU consta de un fragmento o actividad y su archivo de diseño correspondiente.

#### ViewBinding

La vinculación de vista es una función que te permite escribir más fácilmente código que interactúa con las vistas.

#### DataBinding

Vincula los componentes de la IU con las fuentes de datos de tu app mediante un formato declarativo en lugar de la programación.

#### Lifecycle

Compila componentes optimizados para ciclos de vida que puedan ajustar el comportamiento según el estado actual del ciclo de vida de una actividad o un fragmento.

#### Navigation

Compila y estructura la IU integrada en la app, controla los vínculos directos y navega entre pantallas.

#### Paging

La biblioteca de paginación te ayuda a cargar y mostrar pequeños fragmentos de datos a la vez. La carga de datos parciales a pedido reduce el uso del ancho de banda de la red y los recursos del sistema.

Carga datos en páginas y preséntalos en una RecyclerView.

#### Work

Programa y ejecuta tareas en segundo plano diferibles y basadas en restricciones.

#### Test

Pruebas en Android




## ViewModel

Se diseñó la clase ViewModel a fin de almacenar y administrar datos relacionados con la IU de manera optimizada para los ciclos de vida. La clase ViewModel permite que los datos sobrevivan a cambios de configuración, como las rotaciones de pantallas.

Almacena y administra datos relacionados con la IU, de manera optimizada para los ciclos de vida.

Un objeto ViewModel proporciona los datos para un componente de IU específico, como un fragmento o una actividad, y también incluye lógica empresarial de manejo de datos para comunicarse con el modelo.

Por ejemplo, ViewModel puede llamar a otros componentes para cargar los datos, y puede desviar solicitudes de usuarios para modificar la información. ViewModel no tiene conocimiento sobre los componentes de IU, de manera que no se ve afectado por los cambios de configuración, como la recreación de una actividad debido a la rotación del dispositivo.

Un objeto ViewModel proporciona los datos para un componente de IU específico, como un fragmento o una actividad, y también incluye lógica empresarial de manejo de datos para comunicarse con el modelo. ViewModel no conoce los componentes de IU, de manera que no se ve afectado por los cambios de configuración, como la recreación de una actividad debido a la rotación del dispositivo.

Dado que se espera que los objetos ViewModel duren más que los objetos View correspondientes que se actualizan, no debes incluir referencias directas a objetos View dentro de tu implementación de ViewModel. 

Si necesitas acceder a argumentos del fragmento o actividad puedes usar el módulo SavedState para que nuestro ViewModel lea el argumento directamente. **SavedStateHandle** permite que ViewModel acceda al estado y los argumentos guardados del fragmento o actividad asociados.

`Nota: SavedStateHandle permite que ViewModel acceda al estado y los argumentos guardados del fragmento o actividad asociados.`

### LiveData

LiveData es una clase de contenedor de datos observable. A diferencia de una clase observable regular, LiveData está optimizada para ciclos de vida, lo que significa que respeta el ciclo de vida de otros componentes de las apps, como actividades, fragmentos o servicios.

Es una clase contenedora de datos observable, esta clase la usamos para conectar ViewModel a Activity/Fragment.

El componente LiveData respeta el estado del ciclo de vida de los componentes de tu app, como las actividades, los fragmentos y los servicios, e incluye lógica de limpieza para evitar las fugas de objetos y el consumo de memoria excesivo.

LiveData es una clase que expone datos observables. Otros componentes de tu app pueden supervisar cambios en objetos que usan LiveData. 

El componente LiveData también respeta el estado del ciclo de vida de los componentes de tu app, como las actividades, los fragmentos y los servicios, e incluye lógica de limpieza para evitar las fugas de objetos y el consumo de memoria excesivo.

`Nota: Si ya estás usando una biblioteca como RxJava, puedes continuar usándola en lugar de LiveData.`


## Repositorio

Los módulos de repositorio manejan las operaciones de datos. Proporcionan una API limpia para que el resto de la app pueda recuperar estos datos fácilmente. Saben de dónde obtener los datos y qué llamadas de API deben hacer cuando se actualizan los datos. 

Puedes considerar a los repositorios como mediadores entre diferentes fuentes de datos, como modelos persistentes, servicios web y memorias caché.

El repositorio abstrae las fuentes de datos del resto de la app, podemos proporcionarle la información de varias implementaciones de obtención de datos diferentes, una base de datos, una API y bibliotecas externas como el marco de Android y las bibliotecas de terceros.

Una idea inicial para implementar ViewModel podría consistir en llamar directamente a la fuente de datos a fin de obtener los datos y asignarlos a nuestro objeto LiveData. Aunque este método funciona, el mantenimiento de nuestra app se complica a medida que crece.
Asigna demasiada responsabilidad a la clase ViewModel, lo que infringe el principio de separación de problemas.
Además, el alcance de un ViewModel está vinculado a un ciclo de vida de Activity o Fragment, lo que significa que los datos de la fuente de datos se pierden cuando finaliza el ciclo de vida del objeto de IU asociado.

Por esto ViewModel delega el proceso de obtención de datos a un nuevo módulo, un **repositorio**.

Los módulos de **repositorio** manejan las operaciones de datos. Proporcionan una API limpia para que el resto de la app pueda recuperar estos datos fácilmente.

Saben de dónde obtener los datos y qué llamadas de API deben hacer cuando se actualizan los datos. Puedes considerar a los repositorios como mediadores entre diferentes fuentes de datos, como *modelos persistentes*, *servicios web* y *memorias caché*.


## Fuentes de datos
### Modelo
\* **Room**

La biblioteca de persistencias Room brinda una capa de abstracción para SQLite que permite acceder a la base de datos sin problemas y, al mismo tiempo, aprovechar toda la potencia de SQLite.

Crea, almacena y administra datos persistentes con copia de seguridad en una base de datos SQLite.

Room proporciona una capa de abstracción sobre SQLite que permite acceder a la base de datos sin problemas y, al mismo tiempo, aprovechar toda la potencia de SQLite.

Además, permite observar cambios en la base de datos.

Room es una biblioteca de asignación de objetos de SQLite. Úsala para evitar el código estándar y convertir fácilmente los datos de la tabla de SQLite en objetos. Room ofrece comprobaciones del tiempo de compilación de las declaraciones de SQLite y puede mostrar objetos observables de LiveData.

\* **SQLite**

### Fuente de datos remota
\* **Retrofit** biblioteca para acceder a nuestro backend.


## Project files

app -> java:

**data** (Entity)

**di** (Injection)

**model** (Model, DataSource, Repository)

**view** (Activity, Adapter)

**viewmodel** (ViewModel, ViewModelFactory)

## Enlaces

[**Github Dagger**](https://github.com/google/dagger/releases)

[**Github Retrofit**](https://square.github.io/retrofit/)

[**Room**]()


## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.