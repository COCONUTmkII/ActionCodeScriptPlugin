package by.home.acs.language.commenter

import com.intellij.openapi.actionSystem.IdeActions

class ACSCommentTest : ACSCommenterTestBase() {
    fun testBlockLineComment() = testCommenter("blockLineComment", IdeActions.ACTION_COMMENT_BLOCK)
    fun testSingleLineComment() = testCommenter("singleLineComment", IdeActions.ACTION_COMMENT_LINE)
}
