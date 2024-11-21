package com.jluqgon214.whatsapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jluqgon214.whatsapp.ui.theme.ColorIconos
import com.jluqgon214.whatsapp.ui.theme.ColorIconos2
import com.jluqgon214.whatsapp.ui.theme.ColorTextoSecundario
import com.jluqgon214.whatsapp.ui.theme.ColorTextoSeleccionado
import com.jluqgon214.whatsapp.ui.theme.Fondo
import com.jluqgon214.whatsapp.ui.theme.VerdeOscuro

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Chats", "Novedades", "Comunidades", "Llamadas")
    val selectedIcons =
        listOf(
            Icons.AutoMirrored.Filled.Chat,
            Icons.Filled.SportsSoccer,
            Icons.Filled.Groups,
            Icons.Filled.Phone
        )
    val unselectedIcons = listOf(
        Icons.AutoMirrored.Outlined.Chat,
        Icons.Outlined.SportsSoccer,
        Icons.Outlined.Groups,
        Icons.Outlined.Phone
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Fondo,

        ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item,
                    )
                },
                label = {
                    if (selectedItem == index) {
                        Text(
                            item,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                    } else {
                        Text(item, style = TextStyle(fontSize = 12.sp))
                    }

                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = VerdeOscuro,
                    selectedIconColor = ColorIconos,
                    selectedTextColor = ColorTextoSeleccionado,
                    unselectedTextColor = ColorTextoSecundario,
                    unselectedIconColor = ColorIconos2
                )
            )
        }
    }
}