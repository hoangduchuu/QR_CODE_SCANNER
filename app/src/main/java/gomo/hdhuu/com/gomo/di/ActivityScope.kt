package gomo.hdhuu.com.gomo.di

import javax.inject.Scope

/**
 * This is scope for activities. It lives as long as an activity live.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope