package allastro.horoscopedaily.check.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import allastro.horoscopedaily.check.BR;


public class Horoscope extends BaseObservable {

    private String name;
    private String description;


    public Horoscope(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
}
