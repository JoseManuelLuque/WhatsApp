package com.jluqgon214.whatsapp

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.dhaval2404.imagepicker.ImagePicker
import com.jluqgon214.whatsapp.databinding.ActivityCameraBinding

class Camera : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun seleccionarImagen() {
        ImagePicker.with(this)
            .crop()
            .compress(1024)
            .maxResultSize(1080, 1080)
            .createIntent { intent ->
                resultadoImagen.launch(intent)
            }
    }

    private val resultadoImagen = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            imageUri = data!!.data
        }
        else {
            Toast.makeText(this, "No se ha seleccionado ninguna imagen", Toast.LENGTH_SHORT).show()
        }
    }
}