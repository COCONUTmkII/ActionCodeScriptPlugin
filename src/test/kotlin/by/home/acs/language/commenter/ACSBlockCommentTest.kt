package by.home.acs.language.commenter

import com.intellij.openapi.actionSystem.IdeActions

class ACSBlockCommentTest : ACSCommenterTestBase() {
    override val commentType: String = IdeActions.ACTION_COMMENT_BLOCK

    fun `test multiple line comment`() = doCommenterTest("""
        function void commentTest(void) {
            <selection>int i = 1;
            int j = 1;</selection>
        }
    """, """
        function void commentTest(void) {
            /*int i = 1;
            int j = 1;*/
        }
    """)

    fun `test multiple line uncomment`() = doCommenterTest("""
        function void commentTest(void) {
            <selection>/*int i = 1;
            int j = 1;*/</selection>
        }
    """, """
        function void commentTest(void) {
            int i = 1;
            int j = 1;
        }
    """)
}