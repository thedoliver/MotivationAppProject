package br.com.denis.motivationproject.UI

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.denis.motivationproject.helpers.MotivationConstants
import br.com.denis.motivationproject.R
import br.com.denis.motivationproject.databinding.ActivityUserBinding
import br.com.denis.motivationproject.helpers.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    /*
    Ele faz com que a classe vire uma activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
        verifyUserName()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save){
            handleSave()
        }
    }

    private fun verifyUserName(){
        val nome = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (nome.isNotEmpty()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    private fun handleSave(){
        val name = binding.edittextName.text.toString()

        if (name.isEmpty()){
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }else {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.PERSON_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun setListeners(){
        binding.buttonSave.setOnClickListener(this)
    }
}