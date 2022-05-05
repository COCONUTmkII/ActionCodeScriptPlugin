package by.home.acs.language.stub.type

import by.home.acs.language.ACSLanguage
import by.home.acs.language.psi.ACSElement
import com.intellij.lang.Language
import com.intellij.psi.stubs.ILightStubElementType
import com.intellij.psi.stubs.StubElement
import org.jetbrains.annotations.NonNls

abstract class ACSStubElementType<StubT : StubElement<*>, PsiT: ACSElement?>(@NonNls debugName: String) :
    ILightStubElementType<StubT, PsiT>(debugName, ACSLanguage) {

    override fun getExternalId(): String = "acs." + super.toString()

    override fun getLanguage(): Language = ACSLanguage

}
