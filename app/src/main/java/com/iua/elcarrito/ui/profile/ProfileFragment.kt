package com.iua.elcarrito.ui.profile

import android.app.KeyguardManager
import android.content.Context
import android.content.Context.KEYGUARD_SERVICE
import android.hardware.biometrics.BiometricManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.hardware.fingerprint.FingerprintManagerCompat.from
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentProfileBinding
import com.iua.elcarrito.MyApplication.Companion.preferences
import java.util.concurrent.Executor

class ProfileFragment : Fragment() {

  private lateinit var binding: FragmentProfileBinding
  private lateinit var biometricPrompt: BiometricPrompt

  lateinit var executor: Executor
  lateinit var callBack: BiometricPrompt.AuthenticationCallback
  lateinit var BiometricManager: BiometricManager
  var keyguardManager: KeyguardManager? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentProfileBinding.inflate(inflater,container,false)
    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    super.onViewCreated(view, savedInstanceState)

    binding.CorreoUsuario.text = preferences.getMail()
    binding.textView2.text = preferences.getDireccion()

    binding.imageProfile.setImageURI(Uri.parse(preferences.getImage()))

    binding.editProfile.setOnClickListener {
      biometricAuthResult()
      biometricAuth()
    }
  }

  private fun biometricAuth(){

    val promptInfo = BiometricPrompt.PromptInfo.Builder().apply {
      setTitle("Inicio de sesion")
      setDescription("Utilice la huella digital para acceder a la configuracion de su perfil")
      setNegativeButtonText("Cancelar")
      setAllowedAuthenticators(androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK)
    }.build()


    biometricPrompt.authenticate(promptInfo)

  }

  private fun biometricAuthResult(){

    executor = ContextCompat.getMainExecutor(requireContext())
    keyguardManager = requireContext().getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

    callBack = object : BiometricPrompt.AuthenticationCallback() {
      override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        super.onAuthenticationError(errorCode, errString)
        Log.d("Biometric", "Authentication error: $errString")
      }

      override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
        super.onAuthenticationSucceeded(result)
        Log.d("Biometric", "Authentication succeeded!")
        val navController = findNavController()
        navController.navigate(R.id.action_nav_profile_to_editProfileFragment)
      }

      override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        Log.d("Biometric", "Authentication failed")
      }
    }
    biometricPrompt = BiometricPrompt(this, executor, callBack)
  }

}