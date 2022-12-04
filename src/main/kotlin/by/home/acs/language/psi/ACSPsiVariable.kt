package by.home.acs.language.psi

interface ACSPsiVariable : ACSNamedElement {

    fun getVariableType(): ACSType

    fun isStaticType(): Boolean

    fun isArrayType(): Boolean
}
