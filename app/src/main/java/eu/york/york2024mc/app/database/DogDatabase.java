package eu.york.york2024mc.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DogEntity.class}, version = 1)
public abstract class DogDatabase extends RoomDatabase {

    public abstract DogDao getDogDao();

}
