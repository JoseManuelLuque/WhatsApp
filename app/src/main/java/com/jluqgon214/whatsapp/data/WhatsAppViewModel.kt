package com.jluqgon214.whatsapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.model.Contacto
import com.jluqgon214.whatsapp.model.Mensaje

class WhatsAppViewModel {
    val listaContactos =
        mutableStateListOf(
            Contacto("Contacto 1", R.drawable.c1, 1),
            Contacto("Contacto 2", R.drawable.c2, 2),
            Contacto("Contacto 3", R.drawable.c3, 3),
            Contacto("Contacto 4", R.drawable.c4, 4),
            Contacto("Contacto 5", R.drawable.c5, 5),
            Contacto("Contacto 6", R.drawable.c6, 6),
            Contacto("Contacto 7", R.drawable.c7, 7),
            Contacto("Contacto 8", R.drawable.c8, 8),
            Contacto("Contacto 9", R.drawable.c9, 9),
            Contacto("Contacto 10", R.drawable.c10, 10),
            Contacto("Contacto 11", R.drawable.c11, 11),
            Contacto("Contacto 12", R.drawable.c12, 12)
        )

    val usuario = Contacto("Josema", R.drawable.c12, 0)

    val mensajesPorContacto: MutableMap<Int, MutableList<Mensaje>> = mutableMapOf()

    var searching = mutableStateOf(false)

    var searchText = mutableStateOf("")

    var messageText = mutableStateOf("")

    var contactoActual = mutableStateOf<Contacto?>(null)

    fun agregarMensaje(mensaje: Mensaje) {
        // Agregar a la lista del destinatario
        mensajesPorContacto.getOrPut(mensaje.destinatario) { mutableListOf() }.add(mensaje)

        // Si el destinatario es el usuario actual, agregar también a su lista
        if (mensaje.destinatario == usuario.id) {
            mensajesPorContacto.getOrPut(usuario.id) { mutableListOf() }.add(mensaje)
        } else { // Si el destinatario no es el usuario actual, agregar a la lista del remitente
            mensajesPorContacto.getOrPut(mensaje.remitente.id) { mutableListOf() }.add(mensaje)
        }
    }

    fun actualizarContactoActual(contacto: Contacto) {
        contactoActual.value = contacto
    }

    fun inicializarMensajes() {
        listaContactos.forEach { contacto ->
            mensajesPorContacto[contacto.id] = mutableListOf()
            // Agregar algunos mensajes de ejemplo
            println(contacto.toString())
            agregarMensaje(Mensaje("Hola", usuario, contacto.id))
            agregarMensaje(Mensaje("¿Cómo estás?", contacto, usuario.id))
            agregarMensaje(Mensaje("Hola", usuario, contacto.id))
            agregarMensaje(Mensaje("¿Cómo estás?", contacto, usuario.id))
            agregarMensaje(Mensaje("Hola", usuario, contacto.id))
            agregarMensaje(Mensaje("¿Cómo estás ${usuario.nombre}?", contacto, usuario.id))
        }
    }
}

