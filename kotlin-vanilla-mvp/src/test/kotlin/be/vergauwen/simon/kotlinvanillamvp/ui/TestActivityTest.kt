package be.vergauwen.simon.kotlinvanillamvp.ui

import be.vergauwen.simon.kotlinvanillamvp.BuildConfig
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class , sdk = intArrayOf(21))
class TestActivityTest {

  @Before
  fun setUp() { }

  @Test
  fun preConditions() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).get()
    assertFalse(activity.isThingsShown)
  }

  @Test
  fun testPresenterLazyAssignment() {
    val activity = Robolectric.buildActivity(TestActivity::class.java).get()
    assertTrue(activity.testPresenterNotNull())
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