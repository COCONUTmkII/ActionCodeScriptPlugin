package by.home.acs.language.psi

import by.home.acs.language.ACSLanguage
import com.intellij.psi.tree.IElementType

class ACSTokenType(debugName: String?) : IElementType(debugName.toString(), ACSLanguage) {

    override fun toString(): String {
        return "ACSTokenType." + super.toString()
    }

}