package com.github.matvapps.testtask.main;

import com.github.matvapps.testtask.base.BaseView;
import com.github.matvapps.testtask.model.Location;

/**
 * Created by Alexandr.
 */
public interface MainView extends BaseView {
    void onGetAddress(Location location, String latlng);
}
