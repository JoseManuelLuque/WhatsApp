package com.jluqgon214.whatsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.Mic
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.whatsapp.components.Message
import com.jluqgon214.whatsapp.components.TopBar
import com.jluqgon214.whatsapp.data.WhatsAppViewModel

@Composable
fun ChatScreen(navController: NavController, viewModel: WhatsAppViewModel) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TopBar(viewModel, navController)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(10f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(viewModel.mensajes) { mensaje ->
                        Message(mensaje)
                    }
                }
            }

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
                        .weight(5f)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    value = viewModel.searchText.value,
                    onValueChange = { viewModel.searchText.value = it },
                    shape = shape,
                    leadingIcon = {
                        IconButton(
                            onClick = {
                                //TODO EMOJIS
                            },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.EmojiEmotions,
                                contentDescription = "EMOJIES"
                            )
                        }
                    },
                    trailingIcon = {
                        Row(
                            modifier = Modifier.padding(16.dp),
                        ) {
                            IconButton(
                                onClick = {
                                    //TODO EMOJIS
                                },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.AttachFile,
                                    contentDescription = "EMOJIES"
                                )
                            }
                            IconButton(
                                onClick = {
                                    //TODO EMOJIS
                                },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.CameraAlt,
                                    contentDescription = "Camera"
                                )
                            }
                        }
                    },
                    placeholder = { Text("Mensaje") },
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

                FloatingActionButton(
                    content = {
                        Icon(
                            imageVector = Icons.Outlined.Mic,
                            contentDescription = "Audio"
                        )
                    },
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        //TODO RECORD AUDIO
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                    containerColor = Color(0xFF038238),
                    contentColor = Color.White,
                    shape = MaterialTheme.shapes.small.copy(CornerSize(50.dp))
                )
            }
        }
    }
}