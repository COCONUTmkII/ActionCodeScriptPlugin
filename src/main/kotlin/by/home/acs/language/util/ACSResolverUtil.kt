package by.home.acs.language.util

import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.stub.index.ACSFunctionNameIndex
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope

object ACSResolverUtil {
    @JvmStatic
    fun findFunctionsByName(project: Project, name: String): List<ACSPsiFunction> {
        return ACSFunctionNameIndex.getByName(
            name, project, GlobalSearchScope.everythingScope(project)
        )
    }
}
