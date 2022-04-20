package by.home.acs.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ACSFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ACSLanguage) {

    override fun getFileType(): FileType {
        return ACSFileType
    }
}