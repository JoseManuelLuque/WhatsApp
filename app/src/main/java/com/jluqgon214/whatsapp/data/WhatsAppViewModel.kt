package com.jluqgon214.whatsapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.model.Contacto
import com.jluqgon214.whatsapp.model.Mensaje

class WhatsAppViewModel {
    val listaContactos =
        mutableStateListOf(
            Contacto("Contacto 1", R.drawable.c1),
            Contacto("Contacto 2", R.drawable.c2),
            Contacto("Contacto 3", R.drawable.c3),
            Contacto("Contacto 4", R.drawable.c4),
            Contacto("Contacto 5", R.drawable.c5),
            Contacto("Contacto 6", R.drawable.c6),
            Contacto("Contacto 7", R.drawable.c7),
            Contacto("Contacto 8", R.drawable.c8),
            Contacto("Contacto 9", R.drawable.c9),
            Contacto("Contacto 10", R.drawable.c10),
            Contacto("Contacto 11", R.drawable.c11),
            Contacto("Contacto 12", R.drawable.c12)
        )

    val mensajes = mutableStateListOf<Mensaje>(
        Mensaje("Hola", listaContactos[0]),
        Mensaje("Adios", listaContactos[0]),
        Mensaje("Hola", listaContactos[0]),
        Mensaje("Adios", listaContactos[0])
    )

    var searching = mutableStateOf(false)

    var searchText = mutableStateOf("")

    var contactoActual:Contacto? = null
}