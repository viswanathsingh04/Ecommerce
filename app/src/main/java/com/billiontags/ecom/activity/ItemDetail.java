package com.billiontags.ecom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.billiontags.ecom.R;
import com.billiontags.ecom.notification.NotificationCountSetClass;
import com.billiontags.ecom.utility.GlobalActivity;

/**
 * Created by VPS on 03-02-2018.
 */

public class ItemDetail extends GlobalActivity implements View.OnClickListener {
    private ImageView mImage1;
    /**
     * 4.3 *
     */
    private TextView mTextRatings;
    /**
     * 50 ratings \u0026 15 reviews
     */
    private TextView mTextRatingsReviews;
    /**
     * Share
     */
    private TextView mTextAction1;
    private LinearLayout mLayoutAction1;
    /**
     * Similar
     */
    private TextView mTextAction2;
    private LinearLayout mLayoutAction2;
    /**
     * Wishlist
     */
    private TextView mTextAction3;
    private LinearLayout mLayoutAction3;
    private ScrollView mScrollbar;
    /**
     * ADD TO CART
     */
    private TextView mTextActionBottom1;
    /**
     * BUY NOW
     */
    private TextView mTextActionBottom2;
    private LinearLayout mActivityItemDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        initView();
    }

    private void initView() {
        mImage1 = (ImageView) findViewById(R.id.image1);
        mTextRatings = (TextView) findViewById(R.id.text_ratings);
        mTextRatingsReviews = (TextView) findViewById(R.id.text_ratings_reviews);
        mTextAction1 = (TextView) findViewById(R.id.text_action1);
        mLayoutAction1 = (LinearLayout) findViewById(R.id.layout_action1);
        mTextAction2 = (TextView) findViewById(R.id.text_action2);
        mLayoutAction2 = (LinearLayout) findViewById(R.id.layout_action2);
        mTextAction3 = (TextView) findViewById(R.id.text_action3);
        mLayoutAction3 = (LinearLayout) findViewById(R.id.layout_action3);
        mScrollbar = (ScrollView) findViewById(R.id.scrollbar);
        mTextActionBottom1 = (TextView) findViewById(R.id.text_action_bottom1);
        mTextActionBottom2 = (TextView) findViewById(R.id.text_action_bottom2);
        mActivityItemDetails = (LinearLayout) findViewById(R.id.activity_item_details);
        mTextActionBottom1.setOnClickListener(this);
        mTextActionBottom2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.text_action_bottom1) {
            Toast.makeText(ItemDetail.this,"Item added to cart.",Toast.LENGTH_SHORT).show();
            MainActivity.notificationCountCart++;
            NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
        } else if (view.getId() == R.id.text_action_bottom2) {
            MainActivity.notificationCountCart++;
            NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            Toast.makeText(ItemDetail.this,"Item added to buy.",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ItemDetail.this, CartListActivity.class));
        }
    }
}
