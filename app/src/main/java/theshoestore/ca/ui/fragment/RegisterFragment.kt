package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegister.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser(){
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            binding.progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                binding.progressBar.visibility = View.GONE
                findNavController().navigate(
                    RegisterFragmentDirections.actionLoginFragmentToRegisterFragment())
            }, 1000L)
        }else{
            binding.progressBar.visibility = View.GONE
            Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_all_fields_register))
        }
    }
}