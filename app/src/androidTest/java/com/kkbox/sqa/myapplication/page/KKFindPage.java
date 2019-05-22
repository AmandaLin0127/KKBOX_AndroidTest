package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertTrue;


public class KKFindPage extends KKPage {
    public static final BySelector SCROLL = By.res(APP_PACKAGE, "viewpager");
    public static final BySelector ITEM = By.res(APP_PACKAGE, "albumCard_nameText");
    String id = "com.skysoft.kkbox.android:id/viewpager";
    String id2 = "com.skysoft.kkbox.android:id/recycler_sub_item_list";
    String id3 = "com.skysoft.kkbox.android:id/recyclerview";
    String desc = "category_playlist";

    public KKFindPage(UiDevice device) { super(device); }

    public KKFindPage find (String expectedText) throws UiObjectNotFoundException {
        BySelector selector = By.text(expectedText);
        UiScrollable scroll = new UiScrollable(new UiSelector().resourceId(id));
        scroll.scrollDescriptionIntoView(desc);//IntoView(new UiSelector().description(desc))

        UiScrollable scroll2 = new UiScrollable(new UiSelector().resourceId(id2).instance(1));
        scroll2.setAsHorizontalList();
        scroll2.scrollTextIntoView(expectedText);//scroll.scrollTextIntoView(expectedText);
        //assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        this.device.wait(Until.findObject(selector), TIMEOUT).click();
        return this;
    }

    public KKFindPage click (String expectedText) throws UiObjectNotFoundException {
        BySelector selector = By.text(expectedText);
        UiScrollable scroll = new UiScrollable(new UiSelector().resourceId(id3));
        scroll.scrollTextIntoView(expectedText);
        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        this.device.wait(Until.findObject(selector), TIMEOUT).click();
        return this;
    }
}