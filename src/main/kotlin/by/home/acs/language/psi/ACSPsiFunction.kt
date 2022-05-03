package by.home.acs.language.psi

import com.intellij.psi.PsiDocCommentOwner

interface ACSPsiFunction : ACSNamedElement, PsiDocCommentOwner {

    fun getParameterList(): ACScriptFunctionParameterList?

    fun getReturnType(): ACScriptType //how to do it correctly

    /**
     * returns true if function is like print(i: <number>) function
     */
    fun isTypeCastFunction(): Boolean

    /**
     * returns true if function is like HudMessage(s:"test"; something | something_else)
     */
    fun isMultiCastFunction(): Boolean

}
