package by.home.acs.language.psi

interface ACSPsiGlobalVar : ACSNamedElement {

    fun getGlobalVarModifier() : ACSGlobalVarModifier

    fun getGlobalVarType() : ACSType

}
