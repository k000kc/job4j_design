package ru.job4j.ood.lsp;

public class ErrorPrinter extends TextPrinter {
    /**
     * нарушает LSP. изменяет поведение метода print. родительского класса.
     * Необходимо либо добавить ограничение в родительский класс, либо не наследовать класс.
     */
    @Override
    public void print(String text) {
        if (text.length() > 50) {
            throw new IllegalArgumentException("very long text");
        }
        super.print(text);
    }
}
