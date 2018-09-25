package gomo.hdhuu.com.gomo.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Rating(
    val comment: String = "the constructor",
    val qualityOfContent: Int = 10,
    val speakerPerformance: Int = 20
)
