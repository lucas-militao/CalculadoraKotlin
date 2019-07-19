package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    companion object {



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Números
        buttom_um.setOnClickListener{AppendExpressao("1", true)}
        buttom_dois.setOnClickListener{AppendExpressao("2", true)}
        buttom_tres.setOnClickListener{AppendExpressao("3", true)}
        buttom_quatro.setOnClickListener{AppendExpressao("4", true)}
        buttom_cinco.setOnClickListener{AppendExpressao("5", true)}
        buttom_seis.setOnClickListener{AppendExpressao("6", true)}
        buttom_sete.setOnClickListener{AppendExpressao("7", true)}
        buttom_oito.setOnClickListener{AppendExpressao("8", true)}
        buttom_nove.setOnClickListener{AppendExpressao("9", true)}
        buttom_zero.setOnClickListener{AppendExpressao("0", true)}

        //Operadores
        buttom_somar.setOnClickListener{AppendExpressao("+", false)}

        buttom_subtrair.setOnClickListener{AppendExpressao("-", false)}

        buttom_multiplica.setOnClickListener{AppendExpressao("*", false)}

        buttom_dividir.setOnClickListener{AppendExpressao("/", false)}

        buttom_igual.setOnClickListener{

            try {

                txtViewResultado.append(txtViewVisor.text)
                txtViewVisor.text = ""


                val expressao = ExpressionBuilder(txtViewResultado.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResultado = resultado.toLong()
                if (resultado == longResultado.toDouble()) {
                    txtViewResultado.text = resultado.toString()
                } else {
                    txtViewResultado.text = longResultado.toString()
                }

            }

            catch (e : Exception) {
                Toast.makeText(this, "Expressao inválida!", Toast.LENGTH_LONG).show()
            }

        }


        buttom_cancel.setOnClickListener{
            txtViewResultado.text = ""
            txtViewVisor.text = ""
        }
    }

    fun AppendExpressao(string : String, cancel : Boolean) {

        if (cancel) {
            txtViewResultado.text = ""
            txtViewVisor.append(string)
        }
        else {
            txtViewVisor.append(txtViewResultado.text)
            txtViewVisor.append(string)
            txtViewResultado.text = ""
        }

    }
}
