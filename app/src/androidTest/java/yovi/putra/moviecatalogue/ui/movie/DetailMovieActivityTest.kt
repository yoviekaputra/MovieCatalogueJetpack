package yovi.putra.moviecatalogue.ui.movie

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import yovi.putra.moviecatalogue.R
import yovi.putra.moviecatalogue.core.utils.threat.EspressoIdlingResource
import yovi.putra.moviecatalogue.data.entity.MovieItem
import yovi.putra.moviecatalogue.data.repository.DummyRepository
import yovi.putra.moviecatalogue.ui.movie.detail.DetailMovieActivity

@RunWith(AndroidJUnit4::class)
class DetailMovieActivityTest {
    @Rule
    @JvmField var activity = ActivityTestRule(DetailMovieActivity::class.java)
    private lateinit var movie: MovieItem

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
        movie = DummyRepository.getMovieItem()
        val intent = Intent().apply {
            putExtra(DetailMovieActivity.MOVIE, movie)
        }
        activity.launchActivity(intent)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }

    @Test
    fun showDetailMovieTest() {
        onView(withId(R.id.toolbar_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_banner)).check(matches(isDisplayed()))
    }

    @Test
    fun selectIconFavorite() {
        onView(withId(R.id.bt_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_favorite)).perform(click())
        onView(withId(R.id.bt_favorite)).perform(click())
    }
}