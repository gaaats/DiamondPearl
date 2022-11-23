package com.trophymanager.pro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.trophymanager.pro.databinding.FragmentGameBinding
import kotlin.random.Random


class GameFragment : Fragment() {

    private var _biiiiiiinding: FragmentGameBinding? = null
    private val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentGameBinding = null")

    private val listImages = listOf(
        R.drawable.dice_nice,
        R.drawable.o1,
        R.drawable.o2,
        R.drawable.o3,
        R.drawable.o4,
        R.drawable.o5,
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {

        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            val currentDeavble = ContextCompat.getDrawable(requireContext(), listImages.random())
            binding.imgResult.setImageDrawable(currentDeavble)



            Snackbar.make(
                binding.root,
                "\$\$\$You have earned ${Random.nextInt(from = 10, until = 5000)} dollars\$\$\$",
                Snackbar.LENGTH_LONG
            ).show()

            binding.btnTryAgain.setOnClickListener {
                findNavController().navigate(R.id.action_gameFragment_to_velcooomeFragment)
            }


        } catch (e: Exception) {
            makeError()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _biiiiiiinding = null
        super.onDestroy()
    }

    private fun makeError() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun initAlertDialog() {

        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Are you reaaaaly want to exit, the current data will not be save?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

}