package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertTrue;


public class KKSubscribePage extends KKPage {
    private static final BySelector REALEASE = By.text("新發行");
    String scroll_id = "com.skysoft.kkbox.android:id/viewpager";
    String more_id = "com.skysoft.kkbox.android:id/button_overflow";//"com.skysoft.kkbox.android:id/image_like_on";
    public static final BySelector more_button = By.res(APP_PACKAGE, "button_overflow");
    public static final BySelector TITLE = By.res(APP_PACKAGE, "title");
    public static final BySelector ADDTOLIST = By.res(APP_PACKAGE, "button_add_to_new_playlist");
    public static final BySelector ADD_FIELD = By.res(APP_PACKAGE, "text_playlist_name");

    public KKSubscribePage(UiDevice device) {super(device);}

    public KKSubscribePage clickSubscribe (){
        this.device.wait(Until.findObject(REALEASE), TIMEOUT).click();

        assertTrue(this.device.wait(Until.hasObject(REALEASE), TIMEOUT));

        return this;
    }

    public KKSubscribePage scroll (String expectedText) throws UiObjectNotFoundException {
        BySelector selector = By.text(expectedText);
        UiScrollable scroll = new UiScrollable(new UiSelector().resourceId(scroll_id));
        scroll.scrollTextIntoView(expectedText);
        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        //this.device.wait(Until.findObject(selector), TIMEOUT).click();
        return this;
    }

    public KKSubscribePage clickMore () throws UiObjectNotFoundException {
        //this.device.wait(Until.findObject(more_button), TIMEOUT).click();
        UiObject more = this.device.findObject(new UiSelector().resourceId(more_id).instance(1));
        more.click();

        return this;
    }

    public KKSubscribePage clickTitle () throws UiObjectNotFoundException {
        assertTrue(this.device.wait(Until.hasObject(TITLE), TIMEOUT));
        this.device.wait(Until.findObject(TITLE), TIMEOUT).click();

        return this;
    }

    public KKSubscribePage clickAdd (String expectedText) throws UiObjectNotFoundException {
        assertTrue(this.device.wait(Until.hasObject(ADDTOLIST), TIMEOUT));
        this.device.wait(Until.findObject(ADDTOLIST), TIMEOUT).click();

        this.device.wait(Until.findObject(ADD_FIELD), TIMEOUT).setText(expectedText);
        this.device.pressEnter();
        return this;
    }
}
