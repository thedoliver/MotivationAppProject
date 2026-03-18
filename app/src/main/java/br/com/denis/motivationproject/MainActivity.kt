package br.com.denis.motivationproject

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.denis.motivationproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Vamos criar as variaveis do tipo das classe que esta me ajudando
     * a mapear meus elementos do layout
     * que é são as Classes Binding
     * tipo é Activity
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /**
         * passando isso os elementos nasceram e pode ser criados
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**
         * por que eu faço um metodo e nao faço direto do onCreate
         * porque se eu tiver mais de um elemeto que vai ouvir um click eu consigo centralizar isso
         * em um metodo
         */
        setListeners()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase){
            handleNewPhrase()
        }
    }

    private fun handleNewPhrase() {

    }


    private fun setListeners(){
        /**
         * evento OnClick listener passando this, para isso precisa implementar a interface View.OnClickListener
         * e sobreescrever o metodo onClick sendo um interface preciso implementar o contrato
         */
        binding.buttonNewPhrase.setOnClickListener(this)

    }


}