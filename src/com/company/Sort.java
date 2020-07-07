package com.company;

/**
 * Класс с реализацией сортировки методом Шелла для массивов и списков
 */
public class Sort {


    public static void sort(Integer[] data) {
        int n = data.length;

        // создаём вспомогательный массив из элементов вида значение - начальньная позиция
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element((int)data[i], i);
        }

        // сортируем вспомогательный массив пузырьковой сортировкой по значению
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - 1; j++)
                if (elements[j].getValue() > elements[j + 1].getValue()) {
                    Element temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
        // устанавливаем окончательную(правильную) позицию
        for (int i = 0; i < n; i++)
            elements[i].setEndPosition(i);
        // получили массив из элементов с начальной позицией и с позицией
        // на которой должен оказаться
        // сортируем массив по начальной позиции
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (elements[j].getStartPosition() > elements[j + 1].getStartPosition()) {
                    Element temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
        // массив возвращён в исходное состояние
        // проведём сортировку исходного массива с помощью вспомогательного
        int exchangeCount = 0;
        for (int i = 0; i < data.length; i++){
            //Element currentElement = elements[i];
            Element targetElement = findElementByEndPositionIndex(i, elements);
            int el = (int)data[i];
            if (el != targetElement.getValue()) {
                data[i] =targetElement.getValue();
                exchangeCount++;
            }
        }
    }

    private static Element findElementByEndPositionIndex(int index, Element[] elements) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getEndPosition() == index)
                return elements[i];
        }
        return null;
    }
}