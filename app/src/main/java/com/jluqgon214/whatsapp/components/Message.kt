package com.jluqgon214.whatsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.jluqgon214.whatsapp.model.Mensaje
import com.jluqgon214.whatsapp.ui.theme.Contraste
import com.jluqgon214.whatsapp.ui.theme.MensajeRecivido


@Composable
fun Message(mensaje: Mensaje) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =
        if (mensaje.enviado) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(8.dp)), // Aplicamos clip al Surface
            color = if (mensaje.enviado) Contraste else MensajeRecivido
        ) {
            Text(
                mensaje.contenido, color = Color.White, modifier = Modifier
                    .padding(16.dp)
            )
        }
    }

}