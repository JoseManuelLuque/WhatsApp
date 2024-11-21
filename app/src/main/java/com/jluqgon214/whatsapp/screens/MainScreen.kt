package com.jluqgon214.whatsapp.screens

// Importación necesaria para usar iconTint
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.whatsapp.R
import com.jluqgon214.whatsapp.components.BottomNavigationBar
import com.jluqgon214.whatsapp.components.MainTopBar
import com.jluqgon214.whatsapp.data.WhatsAppViewModel
import com.jluqgon214.whatsapp.ui.theme.ColorIconos
import com.jluqgon214.whatsapp.ui.theme.ColorIconos2
import com.jluqgon214.whatsapp.ui.theme.ColorTexto
import com.jluqgon214.whatsapp.ui.theme.ColorTextoSecundario
import com.jluqgon214.whatsapp.ui.theme.Fondo
import com.jluqgon214.whatsapp.ui.theme.VerdeLlamativo

@Composable
fun MainScreen(navController: NavController, viewModel: WhatsAppViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Fondo),
        ) {
            Spacer(Modifier.padding(innerPadding))

            //TOPBAR
            MainTopBar(navController, viewModel)

            //Chats
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(10f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(viewModel.listaContactos) { contacto ->
                        // He hecho lo que es la row del contacto con un Button para que tenga esa animación que da feedback al pulsar ya que np o he conseguido hacer en un Row normal
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(85.dp),
                            onClick = {
                                viewModel.actualizarContactoActual(contacto)
                                Handler(Looper.getMainLooper()).postDelayed({
                                    navController.navigate("ChatScreen")
                                }, 1000)
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
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
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
                                            .size(85.dp)
                                            .padding(end = 16.dp, start = 16.dp)
                                    )
                                    Column {
                                        Text(text = contacto.nombre, color = ColorTexto)

                                        Row {
                                            IconButton(
                                                onClick = { /* Acción al hacer clic */ },
                                                colors = IconButtonDefaults.filledIconButtonColors(
                                                    containerColor = Color.Transparent, // Color del contenedor (transparente)
                                                    contentColor = ColorIconos2 // Color del icono (rojo)
                                                ), modifier = Modifier.size(24.dp).padding(end = 6.dp)
                                            ) {
                                            Icon(
                                                contentDescription = null,
                                                imageVector = Icons.Default.Check
                                            ) }
                                            Text(
                                                text = "Texto de prueba",
                                                color = ColorTextoSecundario
                                            )
                                        }
                                    }
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
                    containerColor = VerdeLlamativo,
                    contentColor = ColorIconos,
                )
            }

            //Bottom
            BottomNavigationBar()
        }
    }


}