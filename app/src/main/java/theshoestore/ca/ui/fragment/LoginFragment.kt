package theshoestore.ca.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener { view ->
            login(view)
        }

        binding.tvRegister.setOnClickListener { view ->
            goToRegister(view)
        }
    }

    private fun goToRegister(view: View) {
        view.findNavController().navigate(
            RegisterFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

    private fun login(view: View) {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        binding.progressBar.visibility = View.VISIBLE

        if(email.isNotEmpty() && password.isNotEmpty()){
            binding.progressBar.visibility = View.GONE
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToListFragment(email, password))
        }else{
            binding.progressBar.visibility = View.GONE
            Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_all_fields))
        }
    }
}