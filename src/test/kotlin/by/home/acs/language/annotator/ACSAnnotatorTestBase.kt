package by.home.acs.language.annotator

import by.home.acs.language.ACSTestBase
import org.intellij.lang.annotations.Language

abstract class ACSAnnotatorTestBase : ACSTestBase() {

    protected fun testAnnotator(@Language("ActionCodeScript")  path: String) {
        myFixture.configureByFile(getPathToFolder(path))
        myFixture.checkHighlighting(false, false, true, true)
    }

}
