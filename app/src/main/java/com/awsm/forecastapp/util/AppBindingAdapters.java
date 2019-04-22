
package com.awsm.forecastapp.util;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.awsm.forecastapp.R;
import com.awsm.forecastapp.di.module.GlideApp;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppBindingAdapters {

    @BindingAdapter("imageUrl")
    public static void loadImage(final ImageView imageView, final String url) {
        GlideApp.with(imageView.getContext())
            .load(url)
            .placeholder(R.drawable.ic_profile)
            .error(R.drawable.ic_profile)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.IMMEDIATE)
            .into(imageView);
    }

    @BindingAdapter("imageUrl2")
    public static void loadImage2(final ImageView imageView, final String url) {
        GlideApp.with(imageView.getContext())
            .load(url)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.IMMEDIATE)
            .into(imageView);
    }

    @BindingAdapter("errorMessage")
    public static void errorMessage(final EditText editText, final String message) {
        if (message != null && message.length() > 2) {
            editText.setError(message);
        }
    }

    @BindingAdapter("setDateTime")
    public static void setDateTime(final TextView textView, final Date date) {
        if (date != null) {
            String value = new SimpleDateFormat("EEE, d MMM yy HH:mm a", Locale.getDefault())
                .format(date);
            textView.setText(value);
        }
    }

    @BindingAdapter("setDate")
    public static void setDate(final TextView textView, final Date date) {
        if (date != null) {
            String value = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
                .format(date);
            textView.setText(value);
        }
    }

    @BindingAdapter("setTime")
    public static void setTime(final TextView textView, final Date date) {
        if (date != null) {
            String value = new SimpleDateFormat("hh:mm a", Locale.getDefault())
                .format(date);
            textView.setText(value);
        }
    }
}
