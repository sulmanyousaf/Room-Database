package com.sulman.studentrecord.data.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.ByteArrayOutputStream

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "student_id")
    val studentId: Int,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null,

    @ColumnInfo(name = "profile_picture")
    var profilePictureByteArray: ByteArray? = null
) {
    fun setProfilePicture(bitmap: Bitmap?) {
        bitmap?.let {
            val stream = ByteArrayOutputStream()
            it.compress(Bitmap.CompressFormat.PNG, 100, stream)
            profilePictureByteArray = stream.toByteArray()
        }
    }

    fun getProfilePicture(): Bitmap? {
        return profilePictureByteArray?.let {
            BitmapFactory.decodeByteArray(it, 0, it.size)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        if (name != other.name) return false
        if (studentId != other.studentId) return false
        if (email != other.email) return false
        if (phoneNumber != other.phoneNumber) return false
        if (profilePictureByteArray != null) {
            if (other.profilePictureByteArray == null) return false
            if (!profilePictureByteArray.contentEquals(other.profilePictureByteArray)) return false
        } else if (other.profilePictureByteArray != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + studentId
        result = 31 * result + email.hashCode()
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        result = 31 * result + (profilePictureByteArray?.contentHashCode() ?: 0)
        return result
    }
}

