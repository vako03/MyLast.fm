package com.benten.lastfmapp.presentation.genres

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.benten.lastfmapp.databinding.FragmentGenresBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GenresFragment : Fragment() {


    private var _binding: FragmentGenresBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GenresViewModel>()
    private val genresAdapter = GenresAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenresBinding.inflate(inflater, container, false)
        return binding.root

    }
    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGenres.adapter = genresAdapter
        binding.rvGenres.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel._uiState.collectLatest {
                    when (it) {
                        is UiState.Error -> Toast.makeText(
                            requireContext(),
                            "Error + ${it.throwable.stackTrace}",
                            Toast.LENGTH_LONG
                        ).show()
                        is UiState.Loading -> Toast.makeText(
                            requireContext(),
                            "Loading",
                            Toast.LENGTH_LONG
                        ).show()
                        is UiState.Success -> genresAdapter.updateAll(it.data.toptags.tag.map {
                            GenreUIModel(
                                it.name,
                                it.reach
                            )
                        })
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
