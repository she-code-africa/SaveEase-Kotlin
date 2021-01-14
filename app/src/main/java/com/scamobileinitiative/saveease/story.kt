package com.scamobileinitiative.saveease

import java.io.Serializable
import java.time.Duration

data class Story(val filePath: String, val duration: Duration) : Serializable