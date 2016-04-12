package be.vergauwen.simon.daggermvp.ui;

import android.app.Activity;
import be.vergauwen.simon.daggermvp.BuildConfig;
import be.vergauwen.simon.daggermvp.RobolectricUnitTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricUnitTestRunner.class)
@Config(constants = BuildConfig.class)
public class TestActivityTest {

    @Before
    public void setUp() throws Exception {}

    @Test
    public void preConditions() throws Exception {
        Activity activity = Robolectric.buildActivity(TestActivity.class).get();
        assertNotNull(activity);
    }

    @Test
    public void testPresenterAfterOnCreate() throws Exception {
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().get();
        assertNotNull(activity.getPresenter());
    }

    @Test
    public void testPresenter() throws Exception {
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().get();
        assertFalse(activity.isThingsShown());
        activity.showThings();
        assertTrue(activity.isThingsShown());
    }

    @Test
    public void testOnResume() throws Exception {
        TestActivity activity =
            Robolectric.buildActivity(TestActivity.class).create().start().resume().get();
        assertTrue(activity.isThingsShown());
    }

    @Test
    public void testOnDestroy() throws Exception {
        TestActivity activity = Robolectric.buildActivity(TestActivity.class)
            .create()
            .start()
            .resume()
            .pause()
            .stop()
            .destroy()
            .get();
        assertTrue(activity.isDestroyed());
    }
}