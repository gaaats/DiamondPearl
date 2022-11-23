package com.trophymanager.pro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.trophymanager.pro.databinding.FragmentChooseBinding

class ChooseFragment : Fragment() {


    private var _binding: FragmentChooseBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentChooseBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            binding.root.background.alpha = 230

            binding.btnVhel.setOnClickListener {
                findNavController().navigate(R.id.action_chooseFragment_to_vheelFragment)
            }
            binding.btnDice.setOnClickListener {
                findNavController().navigate(R.id.action_chooseFragment_to_velcooomeFragment)
            }

        } catch (e: Exception) {
            edfrgtysnackBarError()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun edfrgtysnackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}