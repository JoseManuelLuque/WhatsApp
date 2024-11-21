package com.jluqgon214.whatsapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.whatsapp.data.WhatsAppViewModel
import com.jluqgon214.whatsapp.ui.theme.Principal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(viewModel: WhatsAppViewModel, navController: NavController) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Principal,
            titleContentColor = Color.White
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = viewModel.contactoActual!!.fotoPerfil),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
                Text(
                    viewModel.contactoActual!!.nombre,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /* do something */ }, colors = IconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Videocam,
                    contentDescription = "VideoCall"
                )
            }
            IconButton(
                onClick = { /* do something */ }, colors = IconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Phone,
                    contentDescription = "Call"
                )
            }
            IconButton(
                onClick = { /* do something */ }, colors = IconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Settings"
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateUp()
                }, colors = IconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
        }
    )
}