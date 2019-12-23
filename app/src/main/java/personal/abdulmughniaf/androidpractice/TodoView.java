package personal.abdulmughniaf.androidpractice;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import personal.abdulmughniaf.androidpractice.models.Todo;

public class TodoView extends ConstraintLayout {
    public CheckBox completeCheckBox;
    public TextView descriptionView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView (Todo todo){
        completeCheckBox = findViewById(R.id.completeCheckBox);
        descriptionView = findViewById(R.id.descriptionView);

        completeCheckBox.setChecked(todo.isComplete());
        descriptionView.setText(todo.getDescription());

        if (todo.isComplete()){
            createStrikeThrough();
        }
        setupCheckStateListener();
    }

    private void setupCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener((button, isChecked) ->{
            if (isChecked){
                createStrikeThrough();
            }
            else {
                removeStrikeThrough();
            }
        });
    }

    private void createStrikeThrough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void removeStrikeThrough(){
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
