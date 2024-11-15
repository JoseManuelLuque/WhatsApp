package com.jluqgon214.whatsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.model.Contacto

@Composable
fun MainScreen(modifier: Modifier) {
    val listaContactos = remember {
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
    }

    var searching = remember { mutableStateOf(false) }

    val bottomTextsSize = 12.sp

    var searchText = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        //TOPBAR
        if (searching.value) {
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
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    label = { Text("Buscar...") },
                    shape = shape,
                    leadingIcon = {
                        IconButton(
                            onClick = { searching.value = false },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.arrow_back),
                                contentDescription = null,
                                modifier = Modifier.size(28.dp),
                            )
                        }
                    }
                )
            }
        } else {
            // Cabecera
            Row(
                modifier = Modifier.weight(1f).background(Color(0xFF00C853))
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
                        onClick = { searching.value = true },
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
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(10f)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                items(listaContactos) { contacto ->
                    // He hecho lo que es la row del contacto con un Button para que tenga esa animación que da feedback al pulsar ya que np o he conseguido hacer en un Row normal
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(Color.White),
                        onClick = {
                            val index = listaContactos.indexOf(contacto)
                            if (index > 0) {
                                val contactoSeleccionado =
                                    listaContactos.removeAt(index) // Eliminar el contacto de su posición actual
                                listaContactos.add(
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
                    //TODO: Abrir nuevo chat
                },
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
                containerColor = Color(0xFF038238),
                contentColor = Color.White,
            )
        }

        //Bottom
        Row(
            modifier = Modifier
                .height(200.dp)
                .weight(1f)
                .fillMaxSize()
                .background(Color(0xFF00C853)),
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        //TODO: Ir a Chats
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.chats),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.contactos),
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = bottomTextsSize
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        //TODO: Ir a la novedades
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.status),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.novedades),
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = bottomTextsSize
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        //TODO: Ir a la comunidades
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.group),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.comunidades),
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = bottomTextsSize
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        //TODO: Ir a la llamadas
                    },
                    modifier = Modifier.size(28.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.calls),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.llamadas),
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = bottomTextsSize
                )
            }
        }
    }
}
