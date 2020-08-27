# Android con Kotlin - Android KTX

[**Android KTX**](https://developer.android.com/kotlin/ktx) es un conjunto de extensiones de Kotlin que se incluyen con **Android Jetpack** y **otras bibliotecas de Android**. Las extensiones KTX proporcionan Kotlin conciso e idiomático a Jetpack, la plataforma de Android y otras API. Para ello, esas extensiones aprovechan varias funciones del lenguaje Kotlin, entre las que se incluyen:

* Funciones de extensión
* Propiedades de extensión
* Lambdas
* Parámetros con nombres
* Valores predeterminados de parámetros
* Corrutinas

Para usar Android KTX, añadir al proyecto:

    repositories {
        google()
    }

## Módulos KTX

Android KTX está organizado en módulos y cada módulo contiene uno o más paquetes.

Hay que incluir una dependencia para el artefacto de cada módulo en el archivo *build.gradle* de tu app.

Android KTX incluye un módulo principal único (Core KTX), a excepción de este módulo, todos los artefactos del módulo KTX reemplazan la dependencia subyacente de Java en tu archivo build.gradle. Por ejemplo, puedes reemplazar una dependencia *androidx.fragment:fragment* por *androidx.fragment:fragment-ktx*.

#### Core KTX
El módulo Core KTX ofrece extensiones para bibliotecas comunes que forman parte del marco de trabajo de Android.

    implementation "androidx.core:core-ktx:1.3.1"

#### Collection KTX
Las extensiones de Collection contienen funciones de utilidad para trabajar con las bibliotecas de colección eficientes en cuanto a memoria de Android, como ArrayMap, LongParseArray, LruCache y otras.

    implementation "androidx.collection:collection-ktx:1.1.0"
    
#### Fragment KTX
El módulo Fragment KTX proporciona varias extensiones para simplificar la API del fragmento.

    implementation "androidx.fragment:fragment-ktx:1.2.5"

#### LiveData KTX

#### Navigation KTX

#### Palette KTX

#### Reactive Streams KTX

#### Room KTX

#### SQLite KTX

#### ViewModel KTX

#### WorkManager KTX

#### Firebase KTX

#### Google Maps Platform KTX

#### Play Core KTX

## Enlaces

[**Lista de extensiones de KTX**](https://developer.android.com/kotlin/ktx/extensions-list)

## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.