package com.outerspace.daggergranola.module;

import com.outerspace.daggergranola.model.ParentPojo;

import dagger.Module;
import dagger.Provides;

@Module
public class GranolaParentModule {

    public GranolaParentModule() { }

    @Provides
    public ParentPojo provideParentPojo() {
        ParentPojo pojo = new ParentPojo();
        pojo.parentInfo = "Parent Information";
        return pojo;
    }

    // other @Provides when needed

}
