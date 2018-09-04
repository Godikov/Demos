package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demos.R;
import com.example.administrator.demos.model.Comment;
import com.example.administrator.demos.model.User;
import com.example.administrator.demos.util.CustomTagHandler;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        TextView textView = (TextView) findViewById(R.id.tv);
        TextView textView2 = (TextView) findViewById(R.id.tv2);

        Comment comment = new Comment(new User(1000,"bigMu"),"sd",new User(2000,"袁大头"));

        String content = String.format("<html><%s>%s</%s>: <%s>%s</%s></html>", CustomTagHandler.TAG_COMMENTATOR,
                comment.mCommentator.mName, CustomTagHandler.TAG_COMMENTATOR,
                CustomTagHandler.TAG_CONTENT, comment.mContent, CustomTagHandler.TAG_CONTENT);
        textView.setText(Html.fromHtml(content, null, new CustomTagHandler(this, new CustomTagHandler.OnCommentClickListener() {
            @Override
            public void onCommentatorClick(View view, User commentator) {

            }

            @Override
            public void onReceiverClick(View view, User receiver) {

            }

            @Override
            public void onContentClick(View view, User commentator, User receiver) {

            }
        }))); // 解析标签
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTag(CustomTagHandler.KEY_COMMENTATOR, comment.mCommentator);
        textView.setTag(CustomTagHandler.KEY_RECEIVER, comment.mReceiver);

        Comment comment2 = new Comment(new User(1000,"bigMu"),"sd",new User(2000,"袁大头"));
        String content2 = String.format("<html><%s>%s</%s> 回复 <%s>%s</%s>: <%s>%s</%s><html>",
                CustomTagHandler.TAG_COMMENTATOR, comment2.mCommentator.mName, CustomTagHandler.TAG_COMMENTATOR,
                CustomTagHandler.TAG_RECEIVER, comment2.mReceiver.mName, CustomTagHandler.TAG_RECEIVER,
                CustomTagHandler.TAG_CONTENT, comment2.mContent, CustomTagHandler.TAG_CONTENT);
        textView2.setText(Html.fromHtml(content2, null, new CustomTagHandler(this, new CustomTagHandler.OnCommentClickListener() {
            @Override
            public void onCommentatorClick(View view, User commentator) {

            }

            @Override
            public void onReceiverClick(View view, User receiver) {

            }

            @Override
            public void onContentClick(View view, User commentator, User receiver) {

            }
        }))); // 解析标签
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setTag(CustomTagHandler.KEY_COMMENTATOR, comment2.mCommentator);
        textView2.setTag(CustomTagHandler.KEY_RECEIVER, comment2.mReceiver);

    }
}
