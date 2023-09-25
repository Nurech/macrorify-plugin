package com.github.nurech.macrorifyplugin.language.psi;

import com.github.nurech.macrorifyplugin.language.SimpleLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SimpleTokenType extends IElementType {
  public SimpleTokenType(@NotNull @NonNls String debugName) {
    super(debugName, SimpleLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "YourLanguageTokenType." + super.toString();
  }
}
