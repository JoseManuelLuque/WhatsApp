package com.jluqgon214.whatsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jluqgon214.whatsapp.data.WhatsAppViewModel
import com.jluqgon214.whatsapp.model.Mensaje
import com.jluqgon214.whatsapp.ui.theme.ColorMensajeEnviado
import com.jluqgon214.whatsapp.ui.theme.ColorMensajerecivido
import com.jluqgon214.whatsapp.ui.theme.ColorTexto
import kotlin.collections.getOrPut


@Composable
fun Message(mensaje: Mensaje) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =
        if (mensaje.remitente.id == 0) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(8.dp)), // Aplicamos clip al Surface
            color = if (mensaje.remitente.id == 0) ColorMensajeEnviado else if(mensaje.remitente.id != 0) ColorMensajerecivido else ColorMensajerecivido
        ) {
            Text(
                mensaje.contenido, color = ColorTexto, modifier = Modifier
                    .padding(8.dp)
            )
        }
    }

}