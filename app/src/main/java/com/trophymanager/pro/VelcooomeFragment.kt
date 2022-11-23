package com.trophymanager.pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.trophymanager.pro.databinding.FragmentVelcooomeBinding

class VelcooomeFragment : Fragment() {
    private var _biiiiiiinding: FragmentVelcooomeBinding? = null
    private val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentVelcooomeBinding = null")

    var currentBet = 500


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentVelcooomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {


            binding.btnImgPlus.setOnClickListener {
                currentBet += 100
                binding.tvUserBetCount.text = currentBet.toString()
            }

            binding.btnImgMinus.setOnClickListener {
                if (currentBet >=101){
                    currentBet -= 100
                    binding.tvUserBetCount.text = currentBet.toString()
                }
            }

            binding.btnImgRules.setOnClickListener {
                findNavController().navigate(R.id.action_velcooomeFragment_to_rulesFragment)
            }
            binding.btnImgQuestion.setOnClickListener {
                findNavController().navigate(R.id.action_velcooomeFragment_to_helpFragment)
            }
            binding.btnImgPhotos.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    "Play more game to se photos",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            binding.btnThovDice.setOnClickListener {
                findNavController().navigate(R.id.action_velcooomeFragment_to_loadingFragment)
            }

            binding.btnImgExit.setOnClickListener {
                requireActivity().onBackPressed()
            }



        } catch (e: Exception) {
            makeError()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
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
}