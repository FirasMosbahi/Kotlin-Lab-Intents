package com.gl4.tp12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.activity.result.contract.ActivityResultContracts
import java.net.URI

class MainActivity : AppCompatActivity() {
    lateinit var button: Button;
    lateinit var image: ImageView
    val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == RESULT_OK){
            val imageURI = result.data?.data
            image.setImageURI(imageURI)
        }
    }
    fun onClick(view : View) {
        val intent : Intent = Intent(Intent.ACTION_PICK , MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        pickImage.launch(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById(R.id.imageView)
        image.setImageResource(R.drawable.insat)
        button = findViewById(R.id.button)
        button.setOnClickListener { view -> onClick(view) }
    }
}