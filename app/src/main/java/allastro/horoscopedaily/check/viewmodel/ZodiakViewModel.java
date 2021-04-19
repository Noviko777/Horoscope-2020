package allastro.horoscopedaily.check.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ZodiakViewModel extends ViewModel {

    private MutableLiveData<Integer> horoscopeChooser = new MutableLiveData<>();


    public ZodiakViewModel() {
        horoscopeChooser.setValue(0);
    }

    public MutableLiveData<Integer> getHoroscopeChooser() {
        return horoscopeChooser;
    }

    public void setHoroscopeChooser(Integer horoscopeChooser) {
        this.horoscopeChooser.setValue(horoscopeChooser);
    }
}
