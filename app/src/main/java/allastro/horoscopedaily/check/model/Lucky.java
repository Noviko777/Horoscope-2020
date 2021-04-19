package allastro.horoscopedaily.check.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import allastro.horoscopedaily.check.BR;

public class Lucky extends BaseObservable {

    private String numb1, numb2, numb3, numb4, numb5;

    public Lucky() {
    }

    public Lucky(String numb1, String numb2, String numb3, String numb4, String numb5) {
        this.numb1 = numb1;
        this.numb2 = numb2;
        this.numb3 = numb3;
        this.numb4 = numb4;
        this.numb5 = numb5;
    }

    @Bindable
    public String getNumb1() {
        return numb1;
    }

    public void setNumb1(String numb1) {
        this.numb1 = numb1;
        notifyPropertyChanged(BR.numb1);
    }
    @Bindable
    public String getNumb2() {
        return numb2;
    }

    public void setNumb2(String numb2) {
        this.numb2 = numb2;
        notifyPropertyChanged(BR.numb2);
    }
    @Bindable
    public String getNumb3() {
        return numb3;
    }

    public void setNumb3(String numb3) {
        this.numb3 = numb3;
        notifyPropertyChanged(BR.numb3);
    }
    @Bindable
    public String getNumb4() {
        return numb4;
    }

    public void setNumb4(String numb4) {
        this.numb4 = numb4;
        notifyPropertyChanged(BR.numb4);
    }
    @Bindable
    public String getNumb5() {
        return numb5;
    }

    public void setNumb5(String numb5) {
        this.numb5 = numb5;
        notifyPropertyChanged(BR.numb5);
    }

}
