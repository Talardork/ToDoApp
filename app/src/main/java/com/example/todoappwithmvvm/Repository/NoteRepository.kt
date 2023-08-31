package com.example.todoappwithmvvm.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.todoappwithmvvm.Model.Note
import com.example.todoappwithmvvm.Room.NoteDAO
import java.util.concurrent.Flow

// first we are gonna a constructor for the noteDAO interface bcz our goal is to access the
// dao instead of the entire database

class NoteRepository(private val noteDAO : NoteDAO) {

    val myallnotes : kotlinx.coroutines.flow.Flow<List<Note>> = noteDAO.getallnotes()

    @WorkerThread
    suspend fun insert (note : Note){
        noteDAO.insert(note)

    }
    @WorkerThread
    suspend fun update (note : Note){
        noteDAO.update(note)

    }
    @WorkerThread
    suspend fun delete (note : Note){
        noteDAO.delete(note)

    }
    @WorkerThread
    suspend fun deleteallnotes (){
        noteDAO.deleteallnotes()

    }
}