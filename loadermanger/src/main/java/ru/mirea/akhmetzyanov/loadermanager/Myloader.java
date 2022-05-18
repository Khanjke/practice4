package ru.mirea.akhmetzyanov.loadermanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.concurrent.ThreadLocalRandom;

public class Myloader extends AsyncTaskLoader<String> {

    private String editText;
    public static final String ARG_WORD = "word";

    public Myloader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            editText = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String result = "";
        StringBuffer word = new StringBuffer(editText);
        int index;
        int word_length = word.length();

        for (int i = 0; i < word_length; i++) {
            index = ThreadLocalRandom.current().nextInt(word.length());
            result += word.charAt(index);
            word.deleteCharAt(index);
        }

        return result;
    }
}
