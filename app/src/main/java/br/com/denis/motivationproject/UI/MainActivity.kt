package br.com.denis.motivationproject.UI

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.denis.motivationproject.helpers.MotivationConstants
import br.com.denis.motivationproject.repositories.PhraseRepository
import br.com.denis.motivationproject.R
import br.com.denis.motivationproject.databinding.ActivityMainBinding
import br.com.denis.motivationproject.helpers.SecurityPreferences
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Vamos criar as variaveis do tipo das classe que esta me ajudando
     * a mapear meus elementos do layout
     * que é são as Classes Binding
     * tipo é Activity
     */
    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences

    private val phraseRepository = PhraseRepository()
    private var filter: Int = MotivationConstants.PHRASE.ALL



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /**
         * passando isso os elementos nasceram e pode ser criados
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)


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
        getUsername()
        handleFilter(R.id.image_all)
        refreshPhrase()
    }



    override fun onClick(v: View) {

        val listId = listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)

        if (v.id == R.id.button_new_phrase){
            refreshPhrase()
        }else if (v.id in listId){
            handleFilter(v.id)

        }

    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))



        when (id){
            R.id.image_all -> {
                filter = MotivationConstants.PHRASE.ALL
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))

            }
            R.id.image_happy -> {
                filter = MotivationConstants.PHRASE.HAPPY
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
            R.id.image_sunny -> {
                filter = MotivationConstants.PHRASE.SUNNY
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }
    }

    private fun refreshPhrase() {
        binding.textviewPhrase.text = phraseRepository.getPhrase(filter, Locale.getDefault().language)
    }

    private fun getUsername(){
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.textviewName.text = name
    }


    private fun setListeners(){
        /**
         * evento OnClick listener passando this, para isso precisa implementar a interface View.OnClickListener
         * e sobreescrever o metodo onClick sendo um interface preciso implementar o contrato
         */
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }


}