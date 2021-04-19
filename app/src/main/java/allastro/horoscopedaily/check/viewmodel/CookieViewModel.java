package allastro.horoscopedaily.check.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CookieViewModel extends ViewModel {

    private MutableLiveData<String> answer = new MutableLiveData<>();
    private MutableLiveData<Boolean> answerVisibility = new MutableLiveData<>();

    public CookieViewModel() {
        answer.setValue("");
        answerVisibility.setValue(false);
    }

    public MutableLiveData<String> getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.setValue(answer);
    }

    public MutableLiveData<Boolean> getAnswerVisibility() {
        return answerVisibility;
    }

    public void setAnswerVisibility(Boolean answerVisibility) {
        this.answerVisibility.setValue(answerVisibility);
    }

}
