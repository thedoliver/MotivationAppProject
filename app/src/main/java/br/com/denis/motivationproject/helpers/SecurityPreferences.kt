package br.com.denis.motivationproject.helpers

import android.content.Context

class SecurityPreferences(context: Context) {

    private val shared = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun storeString(key: String, value: String){

        //SharedPreferences
        // salvar informações - chave-valor
        //laves - mudam com pouca frequencia

       /**
         * o Metodo é thread-safe significa que ela é restrita e nao permite mais deu uma entrada
         * de thread ao mesmo tempo
          */

        shared.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{
        return shared.getString(key, "") ?: "" // elvis operator
    }
}