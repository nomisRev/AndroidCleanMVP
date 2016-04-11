package be.vergauwen.simon.cleanmvp.ui

import be.vergauwen.simon.cleanmvp.BuildConfig
import be.vergauwen.simon.cleanmvp.RobolectricUnitTestRunner
import be.vergauwen.simon.ui.TestActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(RobolectricUnitTestRunner::class)
@Config(constants = BuildConfig::class)
class TestActivityTest {

  @Before
  fun setUp() { }

  @Test
  fun preConditions() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).get()
    assertNotNull(activity)
  }

  @Test
  fun testPresenterAfterOnCreate() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).create().get()
    assertNotNull(activity.testPresenterNotNull())
  }

  @Test
  fun testShowThings() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).create().get()
    assertFalse(activity.isThingsShown)
    activity.showThings()
    assertTrue(activity.isThingsShown)
  }

  @Test
  fun testPresenterLoadThings() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).create().get()
    assertFalse(activity.isThingsShown)
    activity.presenterLoadThings()
    assertTrue(activity.isThingsShown)
  }

  @Test
  fun testOnResume() {
    val activity = Robolectric.buildActivity(
        TestActivity::class.java).create().start().resume().get()
    assertTrue(activity.isThingsShown)
  }

  @Test
  fun testOnDestroy() {
    val activity = Robolectric.buildActivity(
        TestActivity::class.java).create().start().resume().pause().stop().destroy().get()
    assertTrue(activity.isDestroyed)
  }

}