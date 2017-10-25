package com.outerspace.daggergranola.component;

import com.outerspace.daggergranola.MainActivity;
import com.outerspace.daggergranola.model.ParentPojo;
import com.outerspace.daggergranola.module.GranolaParentModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { GranolaParentModule.class })
public interface GranolaParentComponent {

    public ParentPojo provideParentPojo();

    public void inject(MainActivity mainActivity);

}
