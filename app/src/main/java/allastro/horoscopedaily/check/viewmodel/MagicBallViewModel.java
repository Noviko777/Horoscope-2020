package allastro.horoscopedaily.check.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MagicBallViewModel extends ViewModel {

    private MutableLiveData<String> answer = new MutableLiveData<>();
    private MutableLiveData<Boolean> answerVisibility = new MutableLiveData<>();

    public MagicBallViewModel() {
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
