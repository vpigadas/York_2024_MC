package eu.york.york2024mc.storage;


import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UserEntity user);

    @Insert
    void insert(UserEntity user) throws Exception;

    @Update
    void update(UserEntity user) throws Exception;

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM UserEntity")
    List<UserEntity> retrieve();

    @Query("SELECT * FROM UserEntity LIMIT 1")
    @Nullable
    UserEntity getFirst();

    @Query("SELECT * FROM UserEntity WHERE name LIKE :name")
    List<UserEntity> retrieve(String name);


}
