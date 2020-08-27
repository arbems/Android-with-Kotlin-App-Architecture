# Android con Kotlin - Patrón de arquitectura Model View ViewModel (MVVM)

![MVVM](https://raw.githubusercontent.com/arbems/Android-with-Kotlin-App-Architecture/master/Gu%C3%ADa%20de%20arquitectura%20de%20apps/0001.png)

### View

La vista se une a las variables y acciones observables expuestas por el ViewModel que generalmente usa el marco de Data Binding.

La vista es responsable de manejar, por ejemplo: Menus, Permisos, Oyentes de eventos, Mostrando diálogos, Toast, Snackbars, trabajando con Android View y Widget, Iniciando actividades, toda la funcionalidad relacionada con Android.Context

El contexto de la aplicación puede: Comience un servicio, Vincularse a un servicio, Enviar una transmisión, Registrar un receptor de transmisión, Cargar valores de recursos.

### ViewModel

Contiene los datos necesarios para la vista. Es una abstracción de la vista y expone propiedades y comandos públicos. Utiliza datos observables para notificar a la vista sobre los cambios. También permite pasar eventos al modelo. El ViewModel solo debe conocer el contexto de la aplicación.

ViewModel es responsable de: Exponer datos, Estado de exposición (progreso, fuera de línea, vacío, error, etc.), Manejo de visibilidad, Validación de entrada, Ejecutando llamadas al modelo, Ejecutando métodos en la vista.

### Model

Contiene un proveedor de datos y el código para buscar y actualizar los datos.

Los datos se pueden recuperar de diferentes fuentes, por ejemplo: API REST, Realm db, SQLite db, Handles broadcast, Shared Preferences, Firebase, etc.


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