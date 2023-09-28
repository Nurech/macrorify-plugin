package com.github.nurech.macrorifyplugin.language;

public class ExampleText {
    static String text = "fun add(a, b) {\n" +
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
    public static String getText() {
        return text;
    }
}
