package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertTrue;

/**
 * Created by amanda on 2019/2/15.
 */

public class KKRadioPage extends KKPage {
    private static final BySelector RADIO = By.text("新發行");
    String scroll_id = "com.skysoft.kkbox.android:id/listview";

    public KKRadioPage(UiDevice device) {super(device);}

    public KKRadioPage openRadio (){
        this.device.wait(Until.findObject(RADIO), TIMEOUT).click();

        assertTrue(this.device.wait(Until.hasObject(RADIO), TIMEOUT));

        return this;
    }

    public KKRadioPage scroll (String expectedText) throws UiObjectNotFoundException {
        BySelector selector = By.text(expectedText);
        UiScrollable scroll = new UiScrollable(new UiSelector().resourceId(scroll_id));
        scroll.scrollTextIntoView(expectedText);
        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        this.device.wait(Until.findObject(selector), TIMEOUT).click();
        return this;
    }

}
