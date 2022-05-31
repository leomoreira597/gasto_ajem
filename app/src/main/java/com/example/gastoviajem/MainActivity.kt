package com.example.gastoviajem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviajem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id === R.id.btn_calcular) {
            calcular()
        }
    }

    private fun validacao(): Boolean {
        return (
                binding.distancia.text.toString() != "" &&
                        binding.preco.text.toString() != "" &&
                        binding.autonomia.text.toString() != "" &&
                        binding.autonomia.text.toString().toFloat() != 0f

                )
    }

    private fun calcular() {
        if (validacao()) {
            val distancia = binding.distancia.text.toString().toFloat()
            val preco = binding.preco.text.toString().toFloat()
            val autonomia = binding.autonomia.text.toString().toFloat()

            val valorTotal = (distancia * preco) / autonomia
            val valorTotalStr = "R$ ${"%.2f".format(valorTotal)}"

            binding.textTotal.text = valorTotalStr
        }
        else{
            Toast.makeText(this, R.string.validacao_todos_os_campos, Toast.LENGTH_SHORT).show()
        }
    }

}