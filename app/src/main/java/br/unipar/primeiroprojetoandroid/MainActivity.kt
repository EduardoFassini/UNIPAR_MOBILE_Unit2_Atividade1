package br.unipar.primeiroprojetoandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Dizer qual tela será carregada:
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //findViewById = comando para buscar na activity através do id
        //<tipo do que buscar> no caso do resultado, um label (textview)
        //precisa do R para buscar componentes nos arquivos padrão
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.inputIdade)
        val botaoValidar = findViewById<Button>(R.id.btnVerificar)

        botaoValidar.setOnClickListener {
            //Pega o valor do input da tela
            val idadeInformada = inputIdade.text.toString()

            if (idadeInformada.isNotEmpty()){

                val idadeInt = idadeInformada.toInt()

                if(idadeInt > 60){
                    resultado.setText("Você é idoso")
                }else if(idadeInt >= 18){
                    resultado.setText("Você está na meia idade")
                }else{
                    resultado.setText("Você é menor de idade")
                }
            }else{
                resultado.setText("Informe um valor!")
            }
        }

    }
    //Outra forma de criar funcao para o botao
    fun limparValores(view: View){
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.inputIdade)
        resultado.setText("")
        input.setText("")
    }
}