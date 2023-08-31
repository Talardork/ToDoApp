package com.example.todoappwithmvvm.View

import android.app.Application
import com.example.todoappwithmvvm.Repository.NoteRepository
import com.example.todoappwithmvvm.Room.NoteDatabase

class NoteApplication : Application() {
    val database by lazy{NoteDatabase.getDatabase(this)}
    val repository by lazy { NoteRepository(database.getNoteDAO()) }

    //by lazy { ... }: This is a delegate property in Kotlin that allows for lazy initialization.
// Lazy initialization means that the value of the property will be computed (or initialized) only
// when it is accessed for the first time. After the initial access, the computed value will be
// stored and reused for subsequent accesses.
}