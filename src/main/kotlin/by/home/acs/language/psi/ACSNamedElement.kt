package by.home.acs.language.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface ACSNamedElement : PsiElement, NavigatablePsiElement, PsiNameIdentifierOwner
