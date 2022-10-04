package com.projetos.roomnote.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    // get all notes from database
    @Query("SELECT * FROM notes")
    fun  getNotes(): Flow<List<Note>>

    // insert notes
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(notes: Note)

    // update notes already created
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateNote(notes: Note)

    // delete notes by id
    @Query("DELETE FROM notes WHERE id=:id")
    suspend fun deleteNote(id: Int)
}