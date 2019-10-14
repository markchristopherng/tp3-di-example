package example.di

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import toothpick.Scope
import toothpick.ktp.KTP
import toothpick.smoothie.lifecycle.closeOnDestroy

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getScope().supportScopeAnnotation(ActivityScope::class.java)
            .installModules(ActivityModule(this))
            .closeOnDestroy(this)
            .inject(this)
    }

    open fun getScope(): Scope {
        return KTP.openRootScope()
            .openSubScope(AppConsants.APPSCOPE)
            .openSubScope(this)
    }
}