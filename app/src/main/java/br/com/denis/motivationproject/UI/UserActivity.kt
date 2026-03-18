package br.com.denis.motivationproject.UI

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.denis.motivationproject.R
import br.com.denis.motivationproject.databinding.ActivityUserBinding
import br.com.denis.motivationproject.helpers.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save){
            handleSave()
        }
    }

    private fun handleSave(){
        SecurityPreferences(applicationContext)

    }

    private fun setListeners(){
        binding.buttonSave.setOnClickListener(this)
    }
}