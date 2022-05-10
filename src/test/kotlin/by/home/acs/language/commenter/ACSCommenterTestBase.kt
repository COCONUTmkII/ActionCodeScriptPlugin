package by.home.acs.language.commenter

import by.home.acs.language.ACSFileType
import by.home.acs.language.ACSTestBase

abstract class ACSCommenterTestBase : ACSTestBase() {

    abstract val commentType: String

    protected fun doCommenterTest(before: String, after: String) =
        testCommentFileByText(before, after) { myFixture.performEditorAction(commentType) }


    private fun testCommentFileByText(before: String, after: String, action: () -> Unit) {
        myFixture.configureByText(ACSFileType, before.trimIndent())
        action()
        myFixture.checkResult(after.trimIndent())
    }
}
