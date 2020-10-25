package theshoestore.ca.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentListBinding
import theshoestore.ca.databinding.FragmentLoginBinding
import theshoestore.ca.viewmodel.ListViewModel
import theshoestore.ca.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.isUserLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (isLoggedIn) {
                findNavController(this).navigate(
                    LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener { v ->
            login(v)
        }

        binding.tvRegister.setOnClickListener { v ->
            goToRegister(v)
        }
    }

    private fun goToRegister(view: View) {
        view.findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

    private fun goToOnBoarding(view: View) {
        view.findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
        viewModel.setUserLoggedIn()
    }

    private fun login(view: View) {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        binding.progressBar.visibility = View.VISIBLE

        if(email.isNotEmpty() && password.isNotEmpty()){
            binding.progressBar.visibility = View.GONE
            requireActivity().hideKeyboard(view)
            goToOnBoarding(view)
            viewModel.setUserLoggedIn()
        }else{
            binding.progressBar.visibility = View.GONE
            Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_all_fields))
        }
    }

    fun Context.hideKeyboard(view: View) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.apply {
            hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}