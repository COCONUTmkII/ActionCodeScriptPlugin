package by.home.acs.language.stub.index

import by.home.acs.language.psi.ACSPsiVariable
import com.intellij.psi.stubs.StubIndexKey

object ACSVariableNameIndex : ACSNameIndex<ACSPsiVariable>() {
    private val KEY = StubIndexKey.createIndexKey<String, ACSPsiVariable>(
        "by.home.acs.language.stub.index.ACSVariableNameIndex"
    )

    override fun getKey(): StubIndexKey<String, ACSPsiVariable> = KEY
}
