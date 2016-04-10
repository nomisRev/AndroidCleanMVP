package be.vergauwen.simon.cleanmvp.ui;

import android.app.Activity;
import be.vergauwen.simon.cleanmvp.BuildConfig;
import be.vergauwen.simon.cleanmvp.RobolectricUnitTestRunner;
import be.vergauwen.simon.ui.TestActivity;
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
    public void setUp() throws Exception {
        Activity activity = Robolectric.buildActivity(TestActivity.class).get();
    }

    @Test
    public void preConditions() throws Exception{
        Activity activity = Robolectric.buildActivity(TestActivity.class).get();
        assertNotNull(activity);
    }

    @Test
    public void testPresenterAfterOnCreate() throws Exception{
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().get();
        assertNotNull(activity.testPresenterNotNull());
    }

    @Test
    public void testShowThings() throws Exception{
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().get();
        assertFalse(activity.isThingsShown());
        activity.showThings();
        assertTrue(activity.isThingsShown());
    }

    @Test
    public void testPresenterLoadThings() throws Exception{
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().get();
        assertFalse(activity.isThingsShown());
        activity.presenterLoadThings();
        assertTrue(activity.isThingsShown());
    }
    
    @Test
    public void testOnResume() throws Exception{
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().start().resume().get();
        assertTrue(activity.isThingsShown());
    }

    @Test
    public void testOnDestroy() throws Exception{
        TestActivity activity = Robolectric.buildActivity(TestActivity.class).create().start().resume().pause().stop().destroy().get();
        assertTrue(activity.isDestroyed());
    }

}