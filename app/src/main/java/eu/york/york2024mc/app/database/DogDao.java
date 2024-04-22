package eu.york.york2024mc.app.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(DogEntity data);

    @Delete
    void delete(DogEntity data);

    @Query("SELECT * FROM Dog")
    List<DogEntity> getAll();

}
