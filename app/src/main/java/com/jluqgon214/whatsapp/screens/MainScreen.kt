package com.jluqgon214.whatsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.components.BottomNavigationBar
import com.jluqgon214.whatsapp.data.WhatsAppViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: WhatsAppViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(Modifier.padding(innerPadding))

            //TOPBAR
            if (viewModel.searching.value) {
                Row(
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF00C853)),
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
                        label = { Text("Buscar...") },
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
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF038238),
                            unfocusedContainerColor = Color(0xFF038238),
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )
                }
            } else {
                // Cabecera
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFF00C853))
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
                            color = Color.White,
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

            //Chats
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(10f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    items(viewModel.listaContactos) { contacto ->
                        // He hecho lo que es la row del contacto con un Button para que tenga esa animación que da feedback al pulsar ya que np o he conseguido hacer en un Row normal
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .background(Color.White),
                            onClick = {
                                viewModel.contactoActual = contacto
                                navController.navigate("ChatScreen")
                                val index = viewModel.listaContactos.indexOf(contacto)
                                if (index > 0) {
                                    val contactoSeleccionado =
                                        viewModel.listaContactos.removeAt(index) // Eliminar el contacto de su posición actual
                                    viewModel.listaContactos.add(
                                        0,
                                        contactoSeleccionado
                                    ) // Agregar el contacto al inicio de la lista
                                }
                            },
                            contentPadding = PaddingValues(start = 0.dp),
                            colors = ButtonColors(
                                containerColor = Color.White,
                                contentColor = Color.Gray,
                                disabledContainerColor = Color.LightGray,
                                disabledContentColor = Color.LightGray
                            ),
                            shape = RectangleShape,
                            content = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Image(
                                        painter = painterResource(id = contacto.fotoPerfil),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(100.dp)
                                            .padding(end = 16.dp, start = 16.dp)
                                    )
                                    Text(text = contacto.nombre, color = Color.Black)
                                }
                            }

                        )
                    }
                }


                FloatingActionButton(
                    content = {
                        Icon(
                            painter = painterResource(R.drawable.chats),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd),
                    onClick = {
                        //TODO: Añadir nuevo chat
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                    containerColor = Color(0xFF038238),
                    contentColor = Color.White,
                )
            }

            //Bottom
            BottomNavigationBar()
        }
    }


}