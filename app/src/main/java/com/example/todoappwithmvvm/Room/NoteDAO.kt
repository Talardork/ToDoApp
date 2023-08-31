package com.example.todoappwithmvvm.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoappwithmvvm.Model.Note
import kotlinx.coroutines.flow.Flow

// dao has to be an interface or an abstract class because we will be writing method codes in this
// it will contain the methods like insert delete update etc.

@Dao
interface NoteDAO {

    @Insert
    suspend fun insert(note : Note)



    @Update
    suspend fun update(note : Note)


    @Delete
    suspend fun delete(note : Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteallnotes()


    @Query("SELECT * FROM note_table ORDER BY id ASC ")
    // * means everything in the table
    // asc means ascending order

    fun getallnotes() : Flow<List<Note>>
    //Flow is a feature of kotlin coroutines

    // now we are creating the room database class that will connect the dao and enitity.

}