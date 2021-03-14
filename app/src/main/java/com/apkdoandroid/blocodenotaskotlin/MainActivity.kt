package com.apkdoandroid.blocodenotaskotlin

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.apkdoandroid.blocodenotaskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencia = Preferencia(applicationContext)

        val btnSalvar = binding.fab
        btnSalvar.setOnClickListener {
            val anotacao = binding.editanotacao.anotacao.toString()

            if (anotacao == ""){
                Toast.makeText(this,"Digite alguma coisa...",Toast.LENGTH_SHORT).show()
            }else{
                preferencia.SalvarAnotacao(anotacao)
                Toast.makeText(this,"Anotação salva com sucesso!",Toast.LENGTH_SHORT).show()
            }
        }
        val anotacao = preferencia.RecuperarAnotacao()
        if (anotacao != ""){
            binding.editanotacao.anotacao.setText(anotacao)
        }



    }

}