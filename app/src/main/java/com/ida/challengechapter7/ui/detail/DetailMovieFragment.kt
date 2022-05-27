package com.ida.challengechapter7.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ida.challengechapter7.R
import com.ida.challengechapter7.databinding.FragmentDetailMovieBinding

class DetailMovieFragment : Fragment() {

    private var _binding : FragmentDetailMovieBinding? = null
    private val binding get() = _binding!!

    private val IMAGE_BASE ="https://image.tmdb.org/t/p/w500/"

    private val args : DetailMovieFragmentArgs by navArgs()

    private lateinit var detailViewModel: DetailFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(requireActivity()).get(DetailFragmentViewModel::class.java)
        val id = args.id
        detailViewModel.getDetail(id)
        detailViewModel.dataDetail.observe(viewLifecycleOwner){
            Glide.with(binding.root).load(IMAGE_BASE+it.posterPath).into(binding.imgDetailMovie)
            binding.tvDetailMovieTittle.text = it.originalTitle
            binding.tvContent.text = it.overview
        }
    }

}