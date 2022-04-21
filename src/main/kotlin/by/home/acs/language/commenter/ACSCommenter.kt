package by.home.acs.language.commenter

import by.home.acs.language.ACSTypes
import com.intellij.lang.CodeDocumentationAwareCommenterEx
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

object ACSCommenter : CodeDocumentationAwareCommenterEx {

    override fun getLineCommentPrefix(): String {
        return "//"
    }

    override fun getBlockCommentPrefix(): String {
        return "/*"
    }

    override fun getBlockCommentSuffix(): String {
        return "*/"
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }

    override fun getLineCommentTokenType(): IElementType? {
        return ACSTypes.END_OF_LINE_COMMENT
    }

    override fun getBlockCommentTokenType(): IElementType? {
        return ACSTypes.C_STYLE_BLOCK_COMMENT
    }

    override fun getDocumentationCommentTokenType(): IElementType? {
        TODO("Not yet implemented")
    }

    override fun getDocumentationCommentPrefix(): String? {
        return "/**"
    }

    override fun getDocumentationCommentLinePrefix(): String? {
        return "*"
    }

    override fun getDocumentationCommentSuffix(): String? {
        return "*/"
    }

    override fun isDocumentationComment(element: PsiComment?): Boolean {
        TODO("Not yet implemented")
    }

    override fun isDocumentationCommentText(element: PsiElement?): Boolean {
        TODO("Not yet implemented")
    }
}