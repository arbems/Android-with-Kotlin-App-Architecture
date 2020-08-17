# Android con Kotlin - Patrón de arquitectura Model View ViewModel (MVVM)

![MVP]()

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

## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.