# Android con Kotlin - Estructura de carpetas de arquitectura app recomendada en Android

*Proyecto que muestra como estructurar las carpetas dentro de aplicación Android usando la arquitectura recomendada por google para apps Android con Kotlin.*

Un proyecto de Android Studio contiene todo lo que define tu lugar de trabajo para una app: desde código fuente y recursos hasta código de prueba y configuraciones de compilación.

![MVVM](https://raw.githubusercontent.com/arbems/Android-with-Kotlin-App-Architecture/master/Gu%C3%ADa%20de%20arquitectura%20de%20apps/0001.png)

# 1. java

Contiene los archivos de código fuente separados por nombres de paquetes, incluido el código de prueba JUnit.

## 1.1. data

El directorio **data** contiene todas las clases que están directamente relacionados con cualquier tipo de datos o gestión de datos utilizados dentro de la aplicación, ya sean clases e interfaces de red, gestión de preferencias, clases de base de datos, modelos de datos, solicitud de red y modelo de respuesta o cualquier otra cosa directamente relacionada con los datos de la aplicación. 

**Todo lo que va dentro de Model en el patrón MVVM.*

### 1.1.1. entities
### 1.1.2. local

El directorio **local** contiene todas las clases que se ocupan de la persistencia de datos localmente en la aplicación. Estas son clases que manejan tanto el almacenamiento como la recuperación de datos locales.

### 1.1.3. remote

El directorio **remote** contiene todas las clases que son responsables de mantener las clases que son responsables o están involucradas en guardar o recuperar datos de una fuente externa a través de una solicitud de red. Esto puede incluir clases tales como retrofit interfaces, factories, interceptores OKHTTP y clases de error, o cualquier otra clase involucrada con datos remotos.

### 1.1.4. repository
 
## 1.2. di

El directorio **di** contiene todas nuestras clases de inyección de dependencia. Esto ayuda a mantener cualquier configuración de DI y responsabilidades separadas del resto de la aplicación.

**Librerías como Dagger, Hilt o Koin*

## 1.3. ui

El directorio de **IU** es responsable de mantener las clases relacionadas con los componentes de IU de la aplicación.

#### 1.3.1. base

El directorio **base** se usa para contener cualquier clase base que pueda ser extendida por otras clases dentro del paquete UI. Por ejemplo, tenemos las clases *BaseActivity* y *BaseFragment* que se utilizan para mantener una lógica común para las actividades y los fragmentos utilizados por nuestra aplicación, lo que significa que no tenemos que repetir el mismo código una y otra vez para cada nueva actividad o fragmento que creamos.

#### 1.3.2. common

El directorio **common** se usa para contener cualquier clase que pueda usarse en las diferentes funciones dentro del paquete de la interfaz de usuario. Por ejemplo, tenemos clases generales ErrorView y RefreshingView que se comparten en varias pantallas diferentes.

#### 1.3.3. MainActivity

La clase **MainActivity** es la actividad principal de la aplicación.

## 1.4. utils

El directorio **utils** se usa para contener cualquier tipo de clase de ayuda o clase de utilidad que podamos usar para cosas como Dialog creation, Snackbar creation, Display metrics, Connectivity checks, Custom Tabs...

## 1.5. MainApplication

La clase de aplicación en Android es la clase base dentro de una aplicación de Android que contiene todos los demás componentes, como *activities* y *services*. La clase de aplicación, o cualquier subclase de la clase de aplicación, se crea una instancia antes que cualquier otra clase cuando se crea el proceso para su aplicación / paquete. Cada aplicación de Android define su propia clase de aplicación. 

# 2. res

Contiene todos los recursos sin código, como diseños XML, strings de IU y también imágenes de mapa de bits, divididos en subdirectorios pertinentes.

# 3. manifests 

Contiene el archivo **AndroidManifest.xml** que describe la naturaleza de la aplicación y cada uno de sus componentes.

## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.
