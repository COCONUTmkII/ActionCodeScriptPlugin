package by.home.acs.language.commenter

import by.home.acs.language.ACSTestBase

abstract class ACSCommenterTestBase : ACSTestBase() {
    private val pathToFolder = getPathToFolder("/commenter/")

    protected fun testCommenter(fileName: String, actionId: String) {
        val file = getTestName("$pathToFolder$fileName.acs", true)
        myFixture.configureByFile(file)
        myFixture.performEditorAction(actionId)
        myFixture.checkResultByFile("$pathToFolder$fileName.txt")
    }
}
