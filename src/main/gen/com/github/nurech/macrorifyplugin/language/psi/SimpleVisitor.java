// This is a generated file. Not intended for manual editing.
package com.github.nurech.macrorifyplugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitFunctionDeclaration(@NotNull SimpleFunctionDeclaration o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull SimpleProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull SimpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
