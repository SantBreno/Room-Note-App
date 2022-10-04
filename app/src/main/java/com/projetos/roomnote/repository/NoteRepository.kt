package com.projetos.roomnote.repository


import com.projetos.roomnote.db.Note
import com.projetos.roomnote.db.NoteDatabase
import javax.inject.Inject

class NoteRepository @Inject constructor(private val db: NoteDatabase) {

    // insert note
    suspend fun insert(notes: Note) = db.getNoteDao().insertNote(notes)

    // get saved not
    fun getSavedNote() = db.getNoteDao().getNotes()

    // update note
    suspend fun update(notes: Note) = db.getNoteDao().updateNote(notes)

    // delete note
    suspend fun deleteNote(id: Int) = db.getNoteDao().deleteNote(id)
}