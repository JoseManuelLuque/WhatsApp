package com.jluqgon214.whatsapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.data.WhatsAppViewModel
import com.jluqgon214.whatsapp.ui.theme.ColorIconos
import com.jluqgon214.whatsapp.ui.theme.ColorIconos2
import com.jluqgon214.whatsapp.ui.theme.ColorTexto
import com.jluqgon214.whatsapp.ui.theme.ColorTextoSecundario
import com.jluqgon214.whatsapp.ui.theme.Cursor
import com.jluqgon214.whatsapp.ui.theme.Fondo
import com.jluqgon214.whatsapp.ui.theme.FondoInput
import com.jluqgon214.whatsapp.ui.theme.VerdeOscuro

@Composable
fun MainTopBar(navController: NavController, viewModel: WhatsAppViewModel) {
    if (viewModel.searching.value) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .background(Fondo),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(50.dp))

            TextField(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                value = viewModel.searchText.value,
                onValueChange = { viewModel.searchText.value = it },
                placeholder = { Text("Buscar...") },
                shape = shape,
                leadingIcon = {
                    IconButton(
                        onClick = { viewModel.searching.value = false },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.arrow_back),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                        )
                    }
                },
                trailingIcon = {
                    if (viewModel.searchText.value.isNotEmpty()) {
                        IconButton(
                            onClick = { viewModel.searchText.value = "" },
                            modifier = Modifier.size(28.dp),
                            colors = IconButtonColors(
                                contentColor = ColorIconos,
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = ColorIconos2
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = FondoInput,
                    unfocusedContainerColor = FondoInput,
                    focusedPlaceholderColor = ColorTextoSecundario,
                    unfocusedPlaceholderColor = ColorTextoSecundario,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Cursor,
                    focusedTextColor = ColorTexto,
                    unfocusedTextColor = ColorTextoSecundario
                )
            )
        }
    } else {
        // Cabecera
        Row(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .background(Fondo)
        ) {
            //Título WhatsApp
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1.5f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.whatsapp),
                    modifier = Modifier.padding(start = 16.dp),
                    color = ColorTexto,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            //Iconos TopBar
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icono Camara
                IconButton(
                    onClick = {
                        //TODO: Ir a la camara
                    },
                    modifier = Modifier.size(28.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                //Icono Buscar
                IconButton(
                    onClick = { viewModel.searching.value = true },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Icono Puntos
                IconButton(
                    onClick = {
                        //TODO: Ir a la congifuración
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.puntos),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

    }

}