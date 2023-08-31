package com.example.todoappwithmvvm.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoappwithmvvm.Model.Note

//unlike other classes this class must be an abstract class and it must inherit from the roomdatabase class.
//we will have to annotate this by writing @database

// version number is about the sqlite database

@Database(entities = [Note::class], version = 1 )
abstract class NoteDatabase : RoomDatabase() {

    //here we will create an abstract function from the noteDAO interface.
    abstract fun getNoteDAO() : NoteDAO
    //it will have no body because it is abstract.

    //now we need to create a single object for the database class.
    //singleton
    companion object{

        @Volatile
        private var INSTANCE : NoteDatabase? = null
        //volatile means make this instance will be visible to all the threads.
        //now lets create the function that will create the instance of this class

        fun getDatabase(context : Context) : NoteDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    NoteDatabase::class.java, "note_database").build()

                INSTANCE = instance
                instance
            }
            

        }
        /**
        This code snippet appears to be written in Kotlin and is related to Android app development
        using the Room Persistence Library, which is a part of Android's architecture components.
        The Room Persistence Library provides an abstraction layer over SQLite to make it easier for
        developers to work with databases in Android apps.

        Let's break down the code step by step:

        1. `fun getDatabase(context: Context): NoteDatabase { ... }`: This is a function called
        `getDatabase` that takes a `Context` parameter and returns an instance of `NoteDatabase`,
        which seems to be a class representing a database using the Room library.

        2. `return INSTANCE ?: synchronized(this) { ... }`: This line is using the Elvis operator
        (`?:`) to return the `INSTANCE` of the `NoteDatabase` if it's not null. If `INSTANCE` is
        null, it enters the synchronized block to create a new instance of the database. The
        synchronized block ensures that only one thread can execute the code inside it at a time,
        preventing potential race conditions during database creation.

        3. Inside the synchronized block:
        a. `val instance = Room.databaseBuilder(...)`: This line is using the `Room.databaseBuilder`
        function to create a new instance of the `NoteDatabase` class. It takes three arguments:
        - `context.applicationContext`: The application's context, usually used to ensure that the
        database instance is tied to the application's lifecycle and not an activity's lifecycle.
        - `NoteDatabase::class.java`: A reference to the `NoteDatabase` class.
        - `"note_database"`: The name of the database. SQLite databases in Android are stored in
        files, and this specifies the name of the file where the database will be stored.

        b. `.build()`: This method call completes the database building process and returns the
        constructed `NoteDatabase` instance.

        c. `INSTANCE = instance`: This line assigns the newly created `NoteDatabase` instance to
        the `INSTANCE` variable. This is done to ensure that subsequent calls to `getDatabase`
        return the same instance rather than creating a new one, which can be important to prevent
        resource waste.

        d. `instance`: This line returns the newly created or already existing `NoteDatabase`
        instance, which will be returned to the calling code.

        In summary, this code snippet defines a function `getDatabase` that utilizes the Singleton
        pattern to ensure that only one instance of the `NoteDatabase` class is created and used
        throughout the app's lifecycle. The code ensures thread safety using the synchronized block
        and returns the existing instance if it exists, or creates a new one if it doesn't.
         **/


    }
    // now we are going to create a repository, it provides better level of abstraction of data and
    // provides a clean api for data access to the rest of the application
    // A repository manages queries And allows you to use multiple backend
    // a Repository implements a logic, whether to fetch data from a network or use result cached
    // in a local database.
}