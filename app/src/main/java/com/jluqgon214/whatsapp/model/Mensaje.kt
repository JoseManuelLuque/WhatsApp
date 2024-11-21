package com.jluqgon214.whatsapp.model

data class Mensaje(
    val contenido: String,
    val remitente: Contacto,
    val destinatario: Int,
    val timestamp: Long = System.currentTimeMillis()
)