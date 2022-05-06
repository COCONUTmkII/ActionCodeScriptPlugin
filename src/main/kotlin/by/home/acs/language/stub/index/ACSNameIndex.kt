package by.home.acs.language.stub.index

import by.home.acs.language.psi.ACSNamedElement
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StringStubIndexExtension

abstract class ACSNameIndex<Psi: ACSNamedElement>protected constructor() : StringStubIndexExtension<Psi>() {
    fun getByName(name: String, project: Project, scope: GlobalSearchScope): List<Psi> =
        get(name, project, scope).filter { isNameMatches(it, name) }

    protected open fun isNameMatches(element: Psi, name: String): Boolean = element.name == name
}
