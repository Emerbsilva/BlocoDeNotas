package com.ebs.blocodenotas

import android.content.Context
import android.content.SharedPreferences

// Criando uma variavel privado que irá receber o contexto da aplicação
class PreferenciaAnotacao(private val context: Context) {

    private val ARQUIVO = "anotacao.preferencia"
    private val CHAVE = "nome"
    private val preferences: SharedPreferences // recupera utilizando este recurso
    private val editor: SharedPreferences.Editor // salva utilizando este recurso

    fun SalvarAnotacao(anotacao: String?){
        editor.putString(CHAVE, anotacao)
        editor.commit()
    }

    fun RecuperarAnotacao(): String?{
        return preferences.getString(CHAVE, "")
    }

    init {
        preferences = context.getSharedPreferences(ARQUIVO, 0)
        editor = preferences.edit()
    }

}