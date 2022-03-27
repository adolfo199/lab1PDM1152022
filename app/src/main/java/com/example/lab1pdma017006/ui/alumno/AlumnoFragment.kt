package com.example.lab1pdma017006.ui.alumno

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lab1pdma017006.R
import com.example.lab1pdma017006.databinding.AlumnoFragmentBinding

class AlumnoFragment : Fragment() {

    companion object {
        fun newInstance() = AlumnoFragment()
    }

    private lateinit var viewModel: AlumnoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity?:this).get(AlumnoViewModel::class.java)
        // TODO: Use the ViewModel
        val view = inflater.inflate(R.layout.alumno_fragment, container, false)
        val binding = AlumnoFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val aceptButton:Button = view.findViewById(R.id.acept_alumno_button)
        val inputName:EditText =view.findViewById(R.id.editTextNombre)
        val inputCarnet:EditText = view.findViewById(R.id.editTextCarnet)

        aceptButton.setOnClickListener(){
            viewModel.showAlumnoData(inputName.text.toString(),inputCarnet.text.toString())
        }
        return view
    }



    override fun onStart() {
        viewModel.init(activity)
        super.onStart()
    }

}