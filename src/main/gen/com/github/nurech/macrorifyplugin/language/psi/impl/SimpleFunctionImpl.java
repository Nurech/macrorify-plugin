// This is a generated file. Not intended for manual editing.
package com.github.nurech.macrorifyplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.nurech.macrorifyplugin.language.psi.SimpleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.nurech.macrorifyplugin.language.psi.*;

public class SimpleFunctionImpl extends ASTWrapperPsiElement implements SimpleFunction {

  public SimpleFunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFunction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

}
