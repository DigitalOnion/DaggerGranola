package com.outerspace.daggergranola;

import android.app.Application;

import com.outerspace.daggergranola.component.DaggerGranolaParentComponent;
import com.outerspace.daggergranola.component.GranolaParentComponent;
import com.outerspace.daggergranola.module.GranolaParentModule;

public class GranolaApplication extends Application {

    private GranolaParentComponent granolaParentComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        granolaParentComponent = DaggerGranolaParentComponent
                .builder()
                .granolaParentModule(new GranolaParentModule())
                .build();
    }

    public GranolaParentComponent getGranolaParentComponent() {
        return granolaParentComponent;
    }
}
