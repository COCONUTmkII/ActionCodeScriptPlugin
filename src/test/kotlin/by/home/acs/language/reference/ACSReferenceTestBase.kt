package by.home.acs.language.reference

import by.home.acs.language.ACSTestBase
import com.intellij.psi.PsiElement
import junit.framework.TestCase

abstract class ACSReferenceTestBase : ACSTestBase() {
    private val pathToFolder = getPathToFolder("reference/")

    fun testReference(fileName: String, elementToVerify: (elem: PsiElement?) -> Boolean)  {
        val file = getTestName("$pathToFolder$fileName", true)
        val reference = myFixture.getReferenceAtCaretPositionWithAssertion(file)
        val resolvedReference = reference.resolve()
        TestCase.assertTrue(elementToVerify(resolvedReference))
    }
}
