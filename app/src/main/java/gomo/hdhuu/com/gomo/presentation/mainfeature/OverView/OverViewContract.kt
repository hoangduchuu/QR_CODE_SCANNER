package gomo.hdhuu.com.gomo.presentation.mainfeature.OverView

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.di.scope.FragmentScope


/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
interface OverViewContract {
    interface View {

    }

    interface Presenter {
        fun getName(): String
    }

    @FragmentScope
    @Subcomponent(modules = [OverViewContract.Module::class])
    interface Component {
        fun inject(fragment: OverViewFragment)


    }

    @dagger.Module
    class Module(val view: View) {
        @FragmentScope
        @Provides
        fun provideView() = view

        @FragmentScope
        @Provides
        fun providePresenter(it: OverViewPresenter): OverViewContract.Presenter = it

        @FragmentScope
        @Provides
        fun provideViewModel() = OverViewModel()
    }


}