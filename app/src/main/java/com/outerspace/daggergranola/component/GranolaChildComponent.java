package com.outerspace.daggergranola.component;

import com.outerspace.daggergranola.MainActivity;
import com.outerspace.daggergranola.model.ChildPojo;
import com.outerspace.daggergranola.module.GranolaChildModule;
import com.outerspace.daggergranola.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {GranolaParentComponent.class}, modules = GranolaChildModule.class)
public interface GranolaChildComponent {

    public ChildPojo provideChildPojo();

    public void inject(MainActivity mainActivity);
}
