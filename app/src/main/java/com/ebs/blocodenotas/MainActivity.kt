package com.ebs.blocodenotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.ebs.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // variavel imutavel que irá receber e recuperar o contexto
        val preferencia = PreferenciaAnotacao(applicationContext)
        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener{

            val anotacaoRecuperado = binding.editConteiner.editAnotacao.text.toString()

            if (anotacaoRecuperado == ""){
                Toast.makeText(this, "Digite alguma coisa...", Toast.LENGTH_LONG).show()
            }else{
                preferencia.SalvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this, "Anotação salva com secesso.", Toast.LENGTH_LONG).show()
            }

        }

        val anotacao = preferencia.RecuperarAnotacao()
        if (anotacao != ""){
            binding.editConteiner.editAnotacao.setText(anotacao)
        }

    }
}