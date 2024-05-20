package eu.york.york2024mc.fragments;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class ActViewModel extends ViewModel {

    private MutableLiveData<Integer> number = new MutableLiveData<Integer>(0);

    public void increaseNumber() {
        int currentNumber = number.getValue();
        number.postValue(++currentNumber);
    }

    public void observe(LifecycleOwner owner, Observer<Integer> observer) {
        number.observe(owner, observer);
    }

}
