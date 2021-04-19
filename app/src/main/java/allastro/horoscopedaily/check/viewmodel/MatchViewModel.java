package allastro.horoscopedaily.check.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MatchViewModel extends ViewModel {

    private String firstZodiak;
    private String secondZodiak;

    private boolean firstPerson = false;
    private boolean secondPerson = false;

    private Integer leftId = 0;
    private Integer rightId = 0;



    public MatchViewModel() {

    }

    public String getFirstZodiak() {
        return firstZodiak;
    }

    public void setFirstZodiak(String firstZodiak) {
        this.firstZodiak = firstZodiak;
    }

    public String getSecondZodiak() {
        return secondZodiak;
    }

    public void setSecondZodiak(String secondZodiak) {
        this.secondZodiak = secondZodiak;
    }

    public Integer getLeftId() {
        return leftId;
    }

    public void setLeftId(Integer leftId) {
        this.leftId = leftId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public boolean isFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(boolean firstPerson) {
        this.firstPerson = firstPerson;
    }

    public boolean isSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(boolean secondPerson) {
        this.secondPerson = secondPerson;
    }


}
