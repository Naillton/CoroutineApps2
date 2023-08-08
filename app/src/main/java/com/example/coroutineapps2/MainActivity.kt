package com.example.coroutineapps2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutineapps2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        sayHello()
        sayHelloBackground()
    }

    // Definindo duas funções que usaram corotinas, a primeira com o Dispatcher main
    // onde usaremos a corotina para atualizar um textView na thread principal.
    // A segunda corotina usara o dispatcher IO onde a thread é excutada em segundo plano
    // e também é usada para oprações com rede ou bloqueio.

    private fun sayHello() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.textOne.text = "Hello ${Thread.currentThread().name}"
        }
    }

    private fun sayHelloBackground() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.textTwo.text = "Hello 2 ${Thread.currentThread().name}"
        }
    }
}