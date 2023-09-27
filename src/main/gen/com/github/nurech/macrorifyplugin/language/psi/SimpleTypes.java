// This is a generated file. Not intended for manual editing.
package com.github.nurech.macrorifyplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.nurech.macrorifyplugin.language.psi.impl.*;

public interface SimpleTypes {

  IElementType FUNCTION_DECLARATION = new SimpleElementType("FUNCTION_DECLARATION");
  IElementType PROPERTY = new SimpleElementType("PROPERTY");

  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CRLF = new SimpleTokenType("CRLF");
  IElementType FUNCTION = new SimpleTokenType("FUNCTION");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType KEY = new SimpleTokenType("KEY");
  IElementType SEPARATOR = new SimpleTokenType("SEPARATOR");
  IElementType VALUE = new SimpleTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == FUNCTION_DECLARATION) {
        return new SimpleFunctionDeclarationImpl(node);
      }
      else if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
