package by.home.acs.language.util

import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.psi.ACSPsiGlobalVar
import by.home.acs.language.stub.index.ACSFunctionNameIndex
import by.home.acs.language.stub.index.ACSGlobalVarNameIndex
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope

object ACSResolverUtil {
    @JvmStatic
    fun findFunctionsByName(project: Project, name: String): List<ACSPsiFunction> {
        return ACSFunctionNameIndex.getByName(
            name, project, GlobalSearchScope.everythingScope(project)
        )
    }

    @JvmStatic
    fun findGlobalVarsByName(project: Project, name: String): List<ACSPsiGlobalVar> {
        return ACSGlobalVarNameIndex.getByName(
            name, project, GlobalSearchScope.everythingScope(project)
        )
    }

    @JvmStatic
    fun findVariablesFromUsage(usage: PsiElement, incompleteCode: Boolean): List<PsiElement> {
        val result = findReferences(usage, incompleteCode).toMutableList()
        TODO("""
            Implement mechanism to check the references from file/project and implement mechanism to track
            incomplete code
        """.trimIndent())
    }

    private fun findReferences(usage: PsiElement, incompleteCode: Boolean): List<PsiElement> {
        TODO("Not yet implemented")
    }
}
