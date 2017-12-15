package com.example.shurik.pdd.test_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shurik.pdd.R;
import com.example.shurik.pdd.test.TestObject;
import com.example.shurik.pdd.test.TestObjectList;

import java.util.List;

/**
 * Created by shurik on 11.12.2017.
 */

public class TestObjectFragment extends Fragment {

    Integer currentPosition;

    public static TestObjectFragment newInstance(int position){

        TestObjectFragment  fragment = new TestObjectFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    public TestObjectFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // чтение параметров из Bundle
        currentPosition = getArguments() != null ? getArguments().getInt("position") : 1;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view   = (View) inflater.inflate(R.layout.fragment_test, null);

        // инициализация переменных - элементов управления

        LinearLayout linearLayout   = (LinearLayout) view.findViewById(R.id.fragment_test_linear_layout);

        TestObjectList testObjectList    = TestObjectList.getInstance(getContext());
        testObjectList.setCurrentIndex(currentPosition);


        TextView    textViewDescription = view.findViewById(R.id.fragment_test_text_view_description);
        textViewDescription.setText(testObjectList.getCurrentTestObject().getDescription());


        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);



        for (int i = 0; i < testObjectList.getCurrentTestObject().getVariantCount(); i++) {

            CheckBox checkBoxVariant = new CheckBox(getContext());
            checkBoxVariant.setLayoutParams(checkBoxParams);
//        checkBoxVariant.setId("fragment_test_checkBox_variant_1");
            int id = 1;
            checkBoxVariant.setId(View.generateViewId());
            checkBoxVariant.setText(testObjectList.getCurrentTestObject().getVariant(i));
            linearLayout.addView(checkBoxVariant);

        }

        return view;

    }
}
