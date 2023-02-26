package ug.kalemba.whatsappnumbergenerator.presentation


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

import ug.kalemba.whatsappnumbergenerator.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
//    val application = WhatsappGeneratorApplication() as Application

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var phoneNumber : String

    private lateinit var imageButton: ImageButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val context = application.applicationContext

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        _binding = FragmentSecondBinding.inflate(inflater, container, false)


        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val number = viewModel.number

//        val number:String = state.name
        val numberObserver = Observer<String>{number ->
        binding.numberText.text = number

            phoneNumber = number
        binding.searchButton.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW
                ).setData(Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber"))
            )
            viewModel.setNumber()
        }


//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.searchButton.setOnClickListener {
            binding.searchButton.visibility = View.GONE
            binding.numberText.visibility=View.VISIBLE
            imageButton.visibility = View.VISIBLE
        }


        viewModel.phoneNumber.observe(viewLifecycleOwner,numberObserver)
        viewModel.setNumber()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}