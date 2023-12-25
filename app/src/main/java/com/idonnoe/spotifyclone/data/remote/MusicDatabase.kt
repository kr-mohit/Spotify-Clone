package com.idonnoe.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.idonnoe.spotifyclone.data.entities.Song
import com.idonnoe.spotifyclone.utils.Constants
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(Constants.SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}