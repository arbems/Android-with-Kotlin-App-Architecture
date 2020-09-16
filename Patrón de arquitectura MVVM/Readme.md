# Android con Kotlin - Patrón de arquitectura Model View ViewModel (MVVM)

Al desarrollar una aplicación para Android, es importante planificar la arquitectura del proyecto. Esto nos permitirá crear aplicaciones complejas, robustas, de buena calidad y fáciles de mantener.

La arquitectura MVVM es una arquitectura Model-View-ViewModel que elimina el estrecho acoplamiento entre cada componente. Lo más importante, en esta arquitectura, los hijos no tienen referencia directa al padre, solo tienen referencia por observables.

![MVVM](https://raw.githubusercontent.com/arbems/Android-with-Kotlin-App-Architecture/master/Gu%C3%ADa%20de%20arquitectura%20de%20apps/0001.png)

## View

Consta del código de la interfaz de usuario (actividad, fragmento), XML. Envía la acción del usuario al ViewModel pero no obtiene la respuesta directamente. Para obtener la respuesta, tiene que suscribirse a los observables que ViewModel le expone.

## ViewModel

Es un puente entre la Vista y el Modelo (lógica de negocios). No tiene ni idea de qué Vista debe usarlo, ya que no tiene una referencia directa a la Vista. Entonces, básicamente, ViewModel no debería ser consciente de la vista con la que está interactuando. Interactúa con el Modelo y expone lo observable que puede ser observado por la Vista.

Contiene los datos necesarios para la vista. Es una abstracción de la vista y expone propiedades y eventos públicos. Utiliza datos observables para notificar a la vista sobre los cambios. También permite pasar eventos al modelo. El ViewModel solo debe conocer el contexto de la aplicación.

#### LiveData

## Model

Representa los datos y la lógica empresarial de la Aplicación Android. Consiste en la lógica empresarial: fuente de datos local y remota, clases de modelo, repositorio.

Los datos se pueden recuperar de diferentes fuentes, por ejemplo: API REST, Realm db, SQLite db, Handles broadcast, Shared Preferences, Firebase, etc.

#### Room

#### Retrofit

## Diferencias entre MVP y MVVM
* MVVM utiliza el Data Binding y, por lo tanto, es una arquitectura más controlada por eventos.
* MVP generalmente tiene una asignación uno a uno entre el presentador y la vista, mientras que MVVM puede asignar muchas vistas a un ViewModel.
* En MVVM el ViewModel no tiene referencia a la vista, mientras que en MVP la vista conoce al presentador.

**MVVM Best Pratice:**
- Avoid references to Views in ViewModels.
- Instead of pushing data to the UI, let the UI observe changes to it.
- Distribute responsibilities, add a domain layer if needed.
- Add a data repository as the single-point entry to your data.
- Expose information about the state of your data using a wrapper or another LiveData.
- Consider edge cases, leaks and how long-running operations can affect the instances in your architecture.
- Don’t put logic in the ViewModel that is critical to saving clean state or related to data. Any call you make from a ViewModel can be the last one.


## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.