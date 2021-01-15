package com.example.testproject4


import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null
    private val callBack = object: CallBack{
        override fun onCLick() {
            var videoView = requireActivity().findViewById<VideoView>(R.id.video)
            val mediaController = MediaController(requireContext())
            val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
            val text = requireActivity().findViewById<TextView>(R.id.text)
            mediaController.setAnchorView(videoView)
            val onlineUri = Uri.parse("https://cdn.videvo.net/videvo_files/video/free/2017-09/small_watermarked/170804_C_Lombok_061_preview.webm")
            Log.v("Checking","Im here2")
            videoView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
            Handler().postDelayed({ text.visibility = View.VISIBLE }, 7000)
            Handler().postDelayed({ text.visibility = View.GONE }, 13000)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(onlineUri)
            videoView.requestFocus()
            videoView.start()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        adapter = RecyclerViewAdapter(callBack)
        recyclerView.adapter = adapter

    }
}