package gomo.hdhuu.com.gomo.presentation.mainfeature.root

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.di.ActivityScope
import gomo.hdhuu.com.gomo.presentation.mainfeature.OverView.OverViewContract

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
interface HomeContract {
    interface View {

    }

    interface Presenter {

    }


    @ActivityScope
    @Subcomponent(modules = [HomeContract.Module::class])
    interface Component {
        fun inject(activity: HomeActivity)

        /**
         * plus for fragments are child of @activity
         */
        fun plus(module: OverViewContract.Module): OverViewContract.Component

    }

    @dagger.Module
    class Module(val view: View) {
        @ActivityScope
        @Provides
        fun provideView() = view

        @ActivityScope
        @Provides
        fun providePresenter(it: HomePresenter): HomeContract.Presenter = it

        @ActivityScope
        @Provides
        fun provideViewModel() = HomeViewModel()
    }
}