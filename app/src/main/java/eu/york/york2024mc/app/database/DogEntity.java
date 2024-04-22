package eu.york.york2024mc.app.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "Dog")
public class DogEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogEntity entity = (DogEntity) o;
        return id == entity.id && Objects.equals(name, entity.name) && Objects.equals(image, entity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }
}
