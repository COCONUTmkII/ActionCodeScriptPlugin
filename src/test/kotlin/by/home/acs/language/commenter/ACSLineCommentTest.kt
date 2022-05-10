package by.home.acs.language.commenter

import com.intellij.openapi.actionSystem.IdeActions

class ACSLineCommentTest : ACSCommenterTestBase() {
    override val commentType: String = IdeActions.ACTION_COMMENT_LINE

    fun `test single line comment`() = doCommenterTest(
        "<caret>global int 1 : test;",
        "//global int 1 : test;"
    )

    fun `test single line uncomment`() = doCommenterTest(
        "<caret>//global int 1 : test;",
        "global int 1 : test;"
    )

}