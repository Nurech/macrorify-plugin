package com.github.nurech.macrorifyplugin.language.psi.impl;

import com.github.nurech.macrorifyplugin.language.psi.SimpleProperty;
import com.github.nurech.macrorifyplugin.language.psi.SimpleTypes;
import com.intellij.lang.ASTNode;

public class SimplePsiImplUtil {

  public static String getKey(SimpleProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to simple spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(SimpleProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(SimpleTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

}
