# Android con Kotlin - Estructura de carpetas de las aplicaciones de Android

*Proyecto que muestra como estructurar las carpetas dentro de aplicación Android usando la arquitectura recomendada por google para apps Android con Kotlin.*

# 1. main / java

## 1.1. data

En este directorio realizamos operaciones de datos (Nuestro modelo en el patrón MVVM). 

### 1.1.1. entities
### 1.1.2. local
### 1.1.3. remote
### 1.1.4. repository
 
## 1.2. di

**Inyección de dependencia** con la ayuda de librerías como Dagger, Hilt o Koin.

## 1.3. ui

**Fragmentos** y **ViewModels** que ayudan a mostrar datos al usuario.

#### 1.3.1.  MainActivity

**MainActivity** es la actividad principal de la aplicación.

## 1.4. utils

Funciones y clases de ayuda.

## 1.5. MainApplication

Clase de aplicación principal, cada app de Android define la suya. La clase de aplicación en Android es la clase base dentro de una aplicación de Android que contiene todos los demás componentes, como *activities* y *services*. La clase de aplicación, o cualquier subclase de la clase de aplicación, se crea una instancia antes que cualquier otra clase cuando se crea el proceso para su aplicación / paquete.

# 2. main / res

# 3. AndroidManifest

## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.