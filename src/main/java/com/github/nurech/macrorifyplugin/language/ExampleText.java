package com.github.nurech.macrorifyplugin.language;

public class ExampleText {
    static String text = "// 2. How to Declare Variable\n" +
            "// Use \"var\" to declare variables; no hoisting\n" +
            "var width    = 100;\n" +
            "var image    = \"Cat Picture\";\n" +
            "\n" +
            "// 3. Data Structure\n" +
            "// Arrays are supported; Maps can be feature-requested\n" +
            "var collection = [1, 2, 4, 5];\n" +
            "collection.push(7);\n" +
            "var a          = collection[2];\n" +
            "collection[3]  = 10;\n" +
            "\n" +
            "// 4. Compound Statement - Branching\n" +
            "// \"if-else\" supported; \"switch\" can be feature-requested\n" +
            "if (condition) {\n" +
            "    // ...\n" +
            "} else if (condition) {\n" +
            "    // ...\n" +
            "} else {\n" +
            "    // ...\n" +
            "}\n" +
            "\n" +
            "// Ternary operator supported in 1.4.3+\n" +
            "var a = condition ? 1 : 0;\n" +
            "\n" +
            "// 4. Compound Statement - Control Flow\n" +
            "// - For Loop\n" +
            "for (var i = 0; i < collection.size; i = i + 1) {\n" +
            "    var current = collection[i];\n" +
            "    Con.out(current);\n" +
            "}\n" +
            "\n" +
            "// - While Loop\n" +
            "var i = 0;\n" +
            "while (i < 10) {\n" +
            "    Con.out(i);\n" +
            "    i = i + 1;\n" +
            "}\n" +
            "\n" +
            "// - Do-While Loop\n" +
            "var i = 0;\n" +
            "do {\n" +
            "    Con.out(i);\n" +
            "    i = i + 1;\n" +
            "} while (i < 10);\n" +
            "\n" +
            "// 5. Compound Statement - Function\n" +
            "// Functions declared with \"fun\"\n" +
            "fun add(a, b) {\n" +
            "    return a + b;\n" +
            "}\n" +
            "add(1, 1); // 3\n" +
            "\n" +
            "// Functions as first-class citizens\n" +
            "fun addAsterisk(text) {\n" +
            "    return \"***\" + text + \"***\";\n" +
            "}\n" +
            "\n" +
            "fun print(text, format) {\n" +
            "    var value = text;\n" +
            "    if (format) value = format(text);\n" +
            "    Con.out(value);\n" +
            "}\n" +
            "\n" +
            "print(\"Hello\", addAsterisk);\n" +
            "\n" +
            "// 6. Compound Statement - Class\n" +
            "// Classes declared with \"class\"\n" +
            "class Addition {\n" +
            "    init(a, b) {          // Constructor\n" +
            "        this.a = a;\n" +
            "        this.b = b;\n" +
            "    }\n" +
            "\n" +
            "    a; b;                 // Fields\n" +
            "\n" +
            "    add() {               // Methods\n" +
            "        return this.a + this.b;\n" +
            "    }\n" +
            "\n" +
            "    static add(a, b) {    // Static field\n" +
            "        return a + b;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "var a = new Addition(2, 3);\n" +
            "a.add(); // 5\n";
    public static String getText() {
        return text;
    }
}
