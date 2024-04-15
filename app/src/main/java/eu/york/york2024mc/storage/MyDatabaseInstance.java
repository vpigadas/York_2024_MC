package eu.york.york2024mc.storage;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
abstract class MyDatabaseInstance extends RoomDatabase {

    abstract UserDao getUser();
}
