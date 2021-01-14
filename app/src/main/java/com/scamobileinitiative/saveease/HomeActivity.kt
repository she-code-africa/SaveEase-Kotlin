package com.scamobileinitiative.saveease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import java.io.File
import java.time.Duration

class HomeActivity() : AppCompatActivity() {
    private var stories = mutableListOf<Story>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imageReaderNew(File("/storage/emulated/0", "WhatsApp/Media/.Statuses"))
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = RecyclerAdapter(stories)
    }

    fun imageReaderNew(root: File) {
        val fileList: ArrayList<File> = ArrayList()
        val listAllFiles = root.listFiles()

        if (listAllFiles != null && listAllFiles.isNotEmpty()) {
            for (currentFile in listAllFiles) {
                if (currentFile.name.endsWith(".mp4") || currentFile.name.endsWith(".jpg")) {
                    // File Absolute path
                    Log.e("downloadFilePath: ", currentFile.absolutePath)

                    // File Name
                    Log.e("downloadFileName", currentFile.name)
                    fileList.add(currentFile.absoluteFile)
                    stories.add(Story(currentFile.absolutePath, Duration.ofSeconds(1)))

                }
            }
            Log.w("fileList", "" + fileList.size)
        }
    }
}
