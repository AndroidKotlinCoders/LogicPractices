package com.kotlincoders.ravi.logicpractices;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kotlincoders.ravi.logicpractices.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private GetSetClass getSetClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        getSetClass = new GetSetClass(this);

        activityMainBinding.setLogicvar(getSetClass);
        activityMainBinding.setActivity(this);

        String type = getIntent().getStringExtra("Type");

        if (type == null) {
            type = "Palindrome";
        }

        getSetClass.setType(type);
        getSetClass.setResult(type);
        getSetClass.notifyChange();

        ActionBar abar = getSupportActionBar();
        abar.setTitle(type);

    }

    public void logicFun(String logicType) {
         int originalnumber;
         int remainder = 0;
         int reversenumber = 0;

        int number = Integer.parseInt(String.valueOf(activityMainBinding.editText.getText()));

        Log.e("MainActivity", "logicType====>" + logicType);


        if (logicType.equalsIgnoreCase("Palindrome")) {

            originalnumber = number;

            for (; number != 0; number = number / 10) {
                remainder = number % 10;
                reversenumber = (reversenumber * 10) + remainder;
            }

            if (reversenumber == originalnumber) {

                Log.e("MainActivity", logicType + " Number " + originalnumber);

                getSetClass.setResult(logicType + " Number " + originalnumber);
                getSetClass.notifyChange();

            } else {

                Log.e("MainActivity", "Not " + logicType + " Number " + originalnumber);
                getSetClass.setResult("Not " + logicType + " Number " + originalnumber);
                getSetClass.notifyChange();
            }

        } else if (logicType.equalsIgnoreCase("FabbinociSeries")) {

            int t1 = 0, t2 = 1, nextterm = 0;

            for (int i = 0; i <= number; i++) {
                nextterm = t1 + t2;
                t1 = t2;
                t2 = nextterm;
            }

            getSetClass.setResult("FabbinociSeries Result==>" + nextterm);
            getSetClass.notifyChange();

            Log.e("MainActivity", "Fabbinoci" + nextterm);

        } else if (logicType.equalsIgnoreCase("PrimeNumber")) {

            boolean flag = false;

            int m = number / 2;

            for (int i = 2; i < m; i++) {

                if (number % 2 == 0) {

                    getSetClass.setResult("It is Not Prime==>");
                    flag = true;

                    break;
                }
            }
            if (!flag) {
                getSetClass.setResult("It's Prime==>");
            }

            getSetClass.notifyChange();

            Log.e("MainActivity", "Prime");

        } else if (logicType.equalsIgnoreCase("Factorials")) {

            int factorials = 1;

            for (int i = 1; i < number; i++) {

                factorials = factorials * i;
            }
            getSetClass.setResult("Factorials Result==>" + factorials);
            getSetClass.notifyChange();

            Log.e("MainActivity", "Factorials");

        } else if (logicType.equalsIgnoreCase("Armstrong")) {

            int result = 0, temp = number, remainders;

            while (number > 0) {

                remainders = number % 10;
                result = result + (remainders + remainders + remainders);
                number = number / 10;

            }

            if (temp == result) {

                getSetClass.setResult("it is real Armstrong ");


            } else {

                getSetClass.setResult("it is not Armstrong ");
            }

            getSetClass.notifyChange();

        } else if (logicType.equalsIgnoreCase("PrintStars")) {

            int numROW = number;
            int rowCount = number;
            String temp = "";

            for (int i = 0; i <= numROW; i++) {

                String t = "";

                for (int j = 0; j <= i; j++) {

                    System.out.print("* ");

                    t = t + "*";

                }

                temp = temp + t + "\n";

                System.out.println();

            }

            getSetClass.setResult(temp);
            getSetClass.notifyChange();


        }

    }


}
