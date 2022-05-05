package by.home.acs.language.stub.index

import by.home.acs.language.psi.ACSPsiFunction
import com.intellij.psi.stubs.StubIndexKey

object ACSFunctionNameIndex : ACSNameIndex<ACSPsiFunction>() {
    private val KEY = StubIndexKey.createIndexKey<String, ACSPsiFunction>(
        "by.home.acs.language.stub.index.ACSFunctionNameIndex"
    )

    override fun getKey(): StubIndexKey<String, ACSPsiFunction> = KEY
}