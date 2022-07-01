package by.home.acs.language.stub.index

import by.home.acs.language.psi.ACSPsiGlobalVar
import com.intellij.psi.stubs.StubIndexKey

object ACSGlobalVarNameIndex : ACSNameIndex<ACSPsiGlobalVar>() {
    private val KEY = StubIndexKey.createIndexKey<String, ACSPsiGlobalVar>(
        "by.home.acs.language.stub.index.ACSGlobalVarNameIndex"
    )

    override fun getKey(): StubIndexKey<String, ACSPsiGlobalVar> = KEY

}