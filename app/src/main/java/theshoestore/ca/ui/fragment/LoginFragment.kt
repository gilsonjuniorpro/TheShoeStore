package theshoestore.ca.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentLoginBinding
import theshoestore.ca.viewmodel.*

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginViewModelFactory: LoginViewModelFactory
    //private val navController by lazy { NavHostFragment.findNavController(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        loginViewModelFactory = LoginViewModelFactory(requireContext())
        loginViewModel = ViewModelProvider(this, loginViewModelFactory)
            .get(LoginViewModel::class.java)

        binding.loginViewModel = loginViewModel

        binding.lifecycleOwner = this

        loginViewModel.isUserLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (isLoggedIn) {
                findNavController(requireView()).navigate(R.id.onBoardingFragment)
                /*val action = LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment()
                findNavController(requireView()).navigate(action)*/
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener { view ->
            login(view)
        }

        binding.tvRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun goToRegister() {
        findNavController(requireView()).navigate(
            LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

    private fun goToOnBoarding() {
        loginViewModel.setUserLoggedIn()
    }

    private fun login(view: View) {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        binding.progressBar.visibility = View.VISIBLE

        if(email.isNotEmpty() && password.isNotEmpty()){
            binding.progressBar.visibility = View.GONE
            requireActivity().hideKeyboard(view)
            goToOnBoarding()
            loginViewModel.setUserLoggedIn()
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