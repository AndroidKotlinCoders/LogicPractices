package com.kotlincoders.ravi.logicpractices;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ravi on 2/23/18.
 */

public class GetSetClass extends BaseObservable {

    String result;
    int number;
    String imageUrl;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GetSetClass(Context ctx) {
    }

    @Bindable
    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.obj);

    }

    public GetSetClass(String result, int number) {
        this.result = result;
        this.number = number;
    }

    public GetSetClass(String type, int number, String imageUrl) {
        this.type = type;
        this.number = number;
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
