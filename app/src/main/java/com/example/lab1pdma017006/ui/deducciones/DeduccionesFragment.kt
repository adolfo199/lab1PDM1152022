package com.example.lab1pdma017006.ui.deducciones

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.lab1pdma017006.R

class DeduccionesFragment : Fragment() {

    companion object {
        fun newInstance() = DeduccionesFragment()
    }

    private lateinit var viewModel: DeduccionesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.deducciones_fragment, container, false)
        val dinero: EditText = view.findViewById(R.id.dinero)
        val btn: Button = view.findViewById(R.id.dudeuc_btn)
        val rentaTex:TextView = view.findViewById(R.id.textView4)
        val issText:TextView = view.findViewById(R.id.textView5)
        val afpText:TextView = view.findViewById(R.id.textView6)
        val seguroText:TextView = view.findViewById(R.id.textView7)


        btn.setOnClickListener() {

            var money = dinero.text.toString().toDoubleOrNull()
            if(money==null){
                Toast.makeText(activity,"Introduce el salario",Toast.LENGTH_LONG)
                            }
            else {
                var renta = calcRenta(money)
                var isss = money * 0.03
                var afp = money * 0.725
                var seguro = 0.00
                if (money <= 250) seguro = money * 0.02
                rentaTex.text = "Renta: " + renta.toString()
                issText.text = "Isss: " +isss.toString()
                afpText.text = "Afp: " +afp.toString()
                seguroText.text = "Seguro: " +seguro.toString()
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeduccionesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun calcRenta(salario: Double): Double {
        if (salario < 550) {
            return 0.00
        }
        if (salario > 550.01 && salario < 800) {
            return 0.1 * salario
        }
        if (salario > 800.01 && salario < 2500) {
            return 0.2 * salario
        }
        if (salario > 2500.01) {
            return 0.3 * salario
        }
        return 0.00
    }

}