package eu.york.york2024mc;

import java.util.List;

import eu.york.york2024mc.app.database.DogEntity;

public interface RefreshAdapterListener {

    public void onRefresh(List<DogEntity> dataList);
}
