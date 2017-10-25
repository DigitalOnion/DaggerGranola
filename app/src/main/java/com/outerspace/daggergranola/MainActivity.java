package com.outerspace.daggergranola;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.outerspace.daggergranola.component.DaggerGranolaChildComponent;
import com.outerspace.daggergranola.component.GranolaChildComponent;
import com.outerspace.daggergranola.component.GranolaParentComponent;
import com.outerspace.daggergranola.model.ChildPojo;
import com.outerspace.daggergranola.model.ParentPojo;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    GranolaParentComponent parentComponent;
    GranolaChildComponent childComponent;

    @Inject
    ParentPojo parentPojo;

    @Inject
    ChildPojo  childPojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GranolaApplication app;
        app = (GranolaApplication) this.getApplication();
        parentComponent = app.getGranolaParentComponent();
        parentComponent.inject(this);

        childComponent = DaggerGranolaChildComponent
                .builder()
                .granolaParentComponent(parentComponent)
                .build();
        childComponent.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String sParNull = getApplication().getResources().getString(R.string.parent_is_null);
        String sChiNull = getApplication().getResources().getString(R.string.child_is_null);

        TextView txt;
        txt = (TextView) findViewById(R.id.txt_parent);
        if(parentPojo == null)
            txt.setText(sParNull);
        else
            txt.setText(parentPojo.parentInfo);

        txt = (TextView) findViewById(R.id.txt_child);
        if(childPojo == null)
            txt.setText(sChiNull);
        else
            txt.setText(childPojo.childInfo);
    }

    public void onClickBtnWhatIsThis(View view) {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.title_what_is_this))
                .setMessage(getResources().getString(R.string.intro))
                .setNeutralButton(getResources().getString(R.string.ok), null)
                .show();
    }

}
