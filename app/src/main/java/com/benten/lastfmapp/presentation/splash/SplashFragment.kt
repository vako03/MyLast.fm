package com.benten.lastfmapp.presentation.splash

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.benten.lastfmapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateLogo()
    }
    private fun animateLogo() {
        binding.ivLogo.alpha = 0f
        val alphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 2500L
            interpolator = AccelerateInterpolator()
        }
        alphaAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            binding.ivLogo.alpha = animatedValue
            val scaleFraction = 2 - (1 - animatedValue)
            binding.ivLogo.scaleX = scaleFraction
            binding.ivLogo.scaleX = scaleFraction
                

        }
        alphaAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                goToGenresFragment()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }

        })

        alphaAnimator.start()
    }
        fun  goToGenresFragment(){
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToGenresFragment())


    }




        override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}