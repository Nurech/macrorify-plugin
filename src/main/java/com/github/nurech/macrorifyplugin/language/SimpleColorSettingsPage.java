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
    return "// This section is a little different\n" +
            "// Everything will be in this code box\n" +
            "\n" +
            "// When you learn new programing language\n" +
            "// All you need is these things and it applies to any language be it functional or OOP:\n" +
            "// Data Type, How to declare variable, Data Structure, Compound Statement (Branching Statement, Control Flow Statement, Function, Class)\n" +
            "// EMScript is dynamically typed functional language with some OOP features. Though most of the built-in library use OOP\n" +
            "\n" +
            "\n" +
            "// 1.Data Type\n" +
            "// - Primitive Type:\n" +
            "//  + number: 0, 1, 2.3, -4.5...\n" +
            "//  + string: \"the usual string syntax\\nthis is new line\"\n" +
            "//  + bool: true false\n" +
            "//  + special: null\n" +
            "// - Reference Type:\n" +
            "//  + Array: [1, 3, 5, 6, \"hello\", true, null]\n" +
            "//  + Function: fun doSomething() {  }\n" +
            "//  + Object: class A { }\n" +
            "\n" +
            "// 2. How to declare variable\n" +
            "// Use the keyword \"var\" similar to javascript.\n" +
            "// Variable does not automatically hoist to the top, you must declare before using\n" +
            "var width = 100\n" +
            "var image = \"Cat Piture\"\n" +
            "\n" +
            "// 3. Data Structure\n" +
            "// Currently we only have Array. If you need more like a Map or something, feel free to feature-request\n" +
            "var collection = [1, 2, 4, 5]\n" +
            "collection.push(7) //[1, 2, 4, 5, 7]\n" +
            "var a = collection[2] //get\n" +
            "collection[3] = 10 //set\n" +
            "\n" +
            "// 4. Compound Statement - Branching\n" +
            "// Currently we only have if-else. If you need more like a switch or when, feel free to feature-request\n" +
            "if (condition) {\n" +
            "\n" +
            "} else if (condition) {\n" +
            "\n" +
            "} else {\n" +
            "\n" +
            "}\n" +
            "\n" +
            "// As of 1.4.3+ you can use ternari operator\n" +
            "var a = condition ? 1 : 0\n" +
            "\n" +
            "// 4. Compound Statement - Control Flow\n" +
            "// - for loop\n" +
            "for (var i = 0; i < collection.size; i = i + 1) {\n" +
            "    var current  = collection[i];\n" +
            "    Con.out(current)\n" +
            "}\n" +
            "\n" +
            "// - while loop\n" +
            "var i = 0\n" +
            "while(i < 10) {\n" +
            "    Con.out(i)\n" +
            "    i = i + 1\n" +
            "}\n" +
            "\n" +
            "// - do while loop\n" +
            "var i = 0\n" +
            "do {\n" +
            "    Con.out(i)\n" +
            "    i = i + 1\n" +
            "} while (i < 10)\n" +
            "\n" +
            "// As of 1.4.3+ you can use foreach syntax\n" +
            "var array = [1, 2, 3, 4, 5]\n" +
            "for (var item : array) {\n" +
            "    // do something to every item\n" +
            "}\n" +
            "\n" +
            "// 5. Compound Statement - Function\n" +
            "// Declare function with \"fun\" keyword\n" +
            "fun add(a, b) {\n" +
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
