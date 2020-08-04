import java.lang.Exception

fun main() {
    val estudiantes: ArrayList<Estudiante> = ArrayList()

    do {
        printMenu()
        val option = try {
            readLine()?.toInt()
        } catch (e: Exception) {
            0
        }

        when(option){
            1 -> {
                estudiantes.add(ingresarEstudiantes())
            }
            2 -> {
                mostrarDatos(estudiantes)
            }
        }

    } while (option != 3)
}

fun printMenu() {
    println("""
        **************Elija una opción****************
        1 - Ingresar Estudiante.
        2 - Mostrar datos.
        3 - SALIR
    """.trimIndent())
}

fun ingresarEstudiantes(): Estudiante {
    println("\n\n____ Agregar estudiante ______")
    println("Nombre: ")
    val nombre: String = readLine().toString()
    println("Apellido: ")
    val apellido: String = readLine().toString()
    println("Edad: ")
    val edad: String = readLine().toString()

    val est = Estudiante(nombre, apellido, edad)

    do {
        println("Nombre de clase: ")
        val nombreClase = readLine().toString()
        est.clases.add(nombreClase)

        println("""
            Deseas agregar otra clase S/N?
        """.trimIndent())
        val opcion = readLine().toString().toUpperCase()

    } while (opcion == "S")

    return est


}

fun mostrarDatos(estudiantes: ArrayList<Estudiante>) {
    println("\n\n<<<<<<Datos>>>>")
    if (estudiantes.size == 0) {
        println("No hay Datos")
        return
    }
    var i = 1
    for ( e in estudiantes) {
        println("""
            Etudiante $i
            - ${e.nombre} ${e.apellido}
            ---- Edad: ${e.edad}
        """.trimIndent())
        println("---- Clases:")
        if (e.clases.size > 0) {
            for (c in e.clases) {
                println("\t\t $c")
            }
        } else {
            println("\t No se agregaron clases")
        }
        println("\n")

        i++
    }
}