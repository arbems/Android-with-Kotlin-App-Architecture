# Android con Kotlin - Android Jetpack

[**Jetpack**](https://developer.android.com/jetpack?gclid=CjwKCAjwj975BRBUEiwA4whRBzR4MpOZJrxVGjk-PO0_4Jt2NDWPK-vxejcvgzkL_faJ3NJiP1PH6xoCHB4QAvD_BwE&gclsrc=aw.ds) es un conjunto de bibliotecas que ayuda a los desarrolladores a seguir las prácticas recomendadas, reducir el código estándar y escribir código que funcione de manera coherente en los dispositivos y las versiones de Android para que puedan enfocarse en el código que les interesa.

Esta colección de bibliotecas se pueden usar de manera individual, aunque fueron diseñados para funcionar en conjunto al mismo tiempo que aprovechas las características del lenguaje Kotlin que te permiten aumentar la productividad.

[**AndroidX**](https://developer.android.com/reference/androidx/packages) es el proyecto de código abierto que utiliza el equipo de Android para desarrollar, probar, empaquetar, versionar y lanzar bibliotecas dentro de Jetpack.

Explora las [**bibliotecas de Jetpack**](https://developer.android.com/jetpack/androidx/explorer) con sus descripciones, notas y versiones.

`Nota: Las bibliotecas de Jetpack se publican en el espacio de nombres de androidx.`

## Uso biblioteca de Android Jetpack

Usar la biblioteca de Jetpack en la app

Agrega el repositorio de Google() al archivo build.gradle del proyecto.

    allprojects {
        repositories {
            google()
            jcenter()
        }
    }
    
Luego, puedes agregar componentes de arquitectura de Jetpack:

    dependencies {
        def lifecycle_version = "2.2.0"
        implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
        implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
        ...
    }

Muchas bibliotecas de Jetpack proporcionan extensiones de [**Android KTX**](https://developer.android.com/kotlin/ktx?gclid=CjwKCAjwj975BRBUEiwA4whRByERVNMlHE3i9wL_j0iKHUKIppgEIkUUHjkj0JsKKxpTNscTo9_uaBoC8mUQAvD_BwE&gclsrc=aw.ds). Las extensiones KTX compilan sobre la API basada en Java y aprovechan las funciones específicas del lenguaje Kotlin.


















## Attribution

This code was created by [arbems](https://github.com/arbems) in 2020.