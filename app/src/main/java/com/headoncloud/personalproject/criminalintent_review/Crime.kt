package com.headoncloud.personalproject.criminalintent_review

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Crime(
   @PrimaryKey val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
//    val requiresPolice: Boolean = false
)
