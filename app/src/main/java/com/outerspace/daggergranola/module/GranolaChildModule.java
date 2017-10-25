package com.outerspace.daggergranola.module;

import com.outerspace.daggergranola.model.ChildPojo;

import dagger.Module;
import dagger.Provides;

@Module
public class GranolaChildModule {

    @Provides
    public ChildPojo provideChildPojo() {
        ChildPojo pojo = new ChildPojo();
        pojo.childInfo = "Child Information";
        return pojo;
    }

}
