package by.home.acs.language.psi

interface ACSPsiFunction : ACSNamedElement {

    fun getParameterList(): ACSFunctionParameters?

    fun getReturnType(): ACSFunctionReturnType? //how to do it correctly

    /**
     * returns true if function is like print(i: <number>) function
     */
    fun isTypeCastFunction(): Boolean

    /**
     * returns true if function is like HudMessage(s:"test"; something | something_else)
     */
    fun isMultiCastFunction(): Boolean

}
