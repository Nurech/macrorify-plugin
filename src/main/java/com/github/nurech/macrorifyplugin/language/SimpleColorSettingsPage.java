// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.nurech.macrorifyplugin.language;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SimpleColorSettingsPage implements ColorSettingsPage {

  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
      new AttributesDescriptor("Key", SimpleSyntaxHighlighter.KEY),
      new AttributesDescriptor("Separator", SimpleSyntaxHighlighter.SEPARATOR),
      new AttributesDescriptor("Value", SimpleSyntaxHighlighter.VALUE),
      new AttributesDescriptor("Bad value", SimpleSyntaxHighlighter.BAD_CHARACTER),
      new AttributesDescriptor("Simple function", SimpleSyntaxHighlighter.FUNCTION),
  };

  @Nullable
  @Override
  public Icon getIcon() {
    return SimpleIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new SimpleSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return  "fun add(a, b) {\n" +
            "    return a + b\n" +
            "}\n" +
            "\n" +
            "// Call like normal\n" +
            "add(1, 1) //3\n" +
            "\n" +
            "// Function is first class citizen so you can use them as argument\n" +
            "fun addAsterisk(text) {\n" +
            "    return \"***\" + text + \"***\"\n" +
            "}\n" +
            "\n" +
            "fun print(text, format) {\n" +
            "    var value = text\n" +
            "    if (format)\n" +
            "        value = format(text)\n" +
            "\n" +
            "    Con.out(value)\n" +
            "}\n" +
            "\n" +
            "print(\"Hello\", addAsterisk)\n" +
            "\n" +
            "// As of 1.4.3+, you can now use lambda syntax to create an anonymous function\n" +
            "fun print(text, text => \"***\" + text + \"***\") {\n" +
            "    // Same as above\n" +
            "}\n" +
            "\n" +
            "// 6. Compound Statement - Class\n" +
            "// Use \"class\" keyword\n" +
            "class Addition {\n" +
            "    //constructor\n" +
            "    init(a, b) {\n" +
            "        this.a = a\n" +
            "        this.b = b\n" +
            "    }\n" +
            "\n" +
            "    //fields\n" +
            "    a\n" +
            "    b\n" +
            "\n" +
            "    //methods\n" +
            "    add() {\n" +
            "        return this.a + this.b\n" +
            "    }\n" +
            "\n" +
            "    //static field\n" +
            "    static add(a, b) {\n" +
            "        return a + b\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "// \"new\" is optional\n" +
            "var a = new Addition(2, 3)\n" +
            "a.add() //5\n" +
            "\n" +
            "// access static by class declaration\n" +
            "Addition.add(2, 3) //5\n";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @Override
  public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @Override
  public ColorDescriptor @NotNull [] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Simple";
  }

}
