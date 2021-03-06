package by.home.acs.language.stub

import by.home.acs.language.ACSTestBase
import by.home.acs.language.stub.type.file.ACSFileStubElementType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.DebugUtil
import com.intellij.testFramework.ParsingTestCase.doCheckResult
import java.io.File

abstract class ACSStubTestBase : ACSTestBase() {
    private val pathToFolder = getPathToFolder("/stub/")

    fun testStub(pathWithFile: String) {
        val file = getTestName("$pathToFolder$pathWithFile.acs", true)
        val text = FileUtil.loadFile(File(testDataPath, file))
        val psiFile = myFixture.addFileToProject(file, text)
        val stubTreeText = testStubText(project, psiFile.virtualFile, text)
        doCheckResult(testDataPath, getTestName("$pathToFolder$pathWithFile.txt", true), stubTreeText)
    }

    private fun testStubText(project: Project, file: VirtualFile, fileContent: String): String {
        val path = file.path
        val psi = PsiFileFactory.getInstance(project).createFileFromText(file.name, file.fileType, fileContent)
        assertFalse(path + "File contains errors", DebugUtil.psiToString(psi, true).contains("PsiErrorElement"))
        return DebugUtil.stubTreeToString(ACSFileStubElementType.INSTANCE.builder.buildStubTree(psi))
    }
}