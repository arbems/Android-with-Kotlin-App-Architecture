# Android con Kotlin - Estructura de carpetas de las aplicaciones de Android

*Proyecto que muestra como estructurar las carpetas dentro de aplicación Android usando la arquitectura recomendada por google para apps Android con Kotlin.*

# main / java

## data

En este directorio realizamos operaciones de datos (Nuestro modelo en el patrón MVVM). 

### entities
### local
### remote
### repository
 
## di

**Inyección de dependencia** con la ayuda de librerías como Dagger, Hilt o Koin.

## ui

**Fragmentos** y **ViewModels** que ayudan a mostrar datos al usuario.

#### MainActivity

**MainActivity** es la actividad principal de la aplicación.

## utils

Funciones y clases de ayuda.

## MainApplication

Clase de aplicación principal, cada app de Android define la suya. La clase de aplicación en Android es la clase base dentro de una aplicación de Android que contiene todos los demás componentes, como *activities* y *services*. La clase de aplicación, o cualquier subclase de la clase de aplicación, se crea una instancia antes que cualquier otra clase cuando se crea el proceso para su aplicación / paquete.

# main / res

# AndroidManifest

## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.