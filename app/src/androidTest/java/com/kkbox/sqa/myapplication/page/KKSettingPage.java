package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertTrue;

/**
 * Created by amanda on 2019/2/15.
 */

public class KKSettingPage extends KKPage {
    private static final BySelector SETTING = By.text("設定");
    //String id = "com.skysoft.kkbox.android:id/drawerItem_layout";

    public KKSettingPage(UiDevice device) {super(device);}

    public KKSettingPage set (){
        this.device.wait(Until.findObject(SETTING), TIMEOUT).click();

        assertTrue(this.device.wait(Until.hasObject(SETTING), TIMEOUT));

        return this;
    }
}
