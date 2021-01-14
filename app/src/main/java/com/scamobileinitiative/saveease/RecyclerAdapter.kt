package com.scamobileinitiative.saveease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.status_list_item.view.*
import kotlinx.android.synthetic.main.status_video_list_item.view.*
import java.io.File

private const val POST_TYPE_VIDEO: Int = 0;
private const val POST_TYPE_Image: Int = 1;

class RecyclerAdapter(
    private var story: List<Story>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(story: Story) {
            val mediaController = MediaController(itemView.context)
            mediaController.setAnchorView(itemView.status_video)
            itemView.status_video.setVideoPath(story.filePath)
            itemView.status_video.requestFocus()
            itemView.status_video.start()
        }
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(story: Story) {
            Glide.with(itemView.context).load(File(story.filePath))
                .into(itemView.status_image)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == POST_TYPE_Image) {
            val v =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.status_list_item, parent, false)
            return ImageViewHolder(v)

        } else {
            val v =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.status_video_list_item, parent, false)
            return VideoViewHolder(v)

        }


    }

    override fun getItemCount(): Int {
        return story.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == POST_TYPE_Image) {
            (holder as ImageViewHolder).bind(story[position])
        } else {
            (holder as VideoViewHolder).bind(story[position])
        }


    }

    override fun getItemViewType(position: Int): Int {
        return if (File(story[position].filePath).name.endsWith(".mp4")) {
            POST_TYPE_VIDEO
        } else {
            POST_TYPE_Image
        }
    }

}