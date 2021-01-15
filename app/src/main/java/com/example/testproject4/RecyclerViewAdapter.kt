package com.example.testproject4

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MediaController
import android.widget.VideoView
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val callBack: CallBack) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemImages = intArrayOf(
        R.drawable.mu,
        R.drawable.valencia,
        R.drawable.realmadrid
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView
        var cardView : CardView
        init{
            image = itemView.findViewById(R.id.item_image)
            cardView = itemView.findViewById(R.id.Card_View)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model,parent,false)
        val holder = ViewHolder(v)
        holder.cardView.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos!= -1){
                Log.v("Checking","Im here")
                callBack.onCLick()
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(itemImages[position])

    }

    override fun getItemCount(): Int {
        return itemImages.size
    }
}