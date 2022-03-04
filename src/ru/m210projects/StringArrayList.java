package ru.m210projects;

import java.util.Arrays;

public class StringArrayList implements StringList {

    private String[] array;
    private int size;

    public StringArrayList(int size) {
        array = new String[size];
    }

    private void extend() {
        String[] newarray = new String[Math.max(16, size * size)];
        System.arraycopy(array, 0, newarray, 0, size);
        array = newarray;
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.

    @Override
    public String add(String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        if(size >= array.length - 1) {
            extend();
        }

        array[size++] = item;
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.

    @Override
    public String add(int index, String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index + " out of bounds " + size);
        }

        if(size == array.length) {
            extend();
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;

        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс меньше
    // фактического количества элементов
    // или выходит за пределы массива.

    @Override
    public String set(int index, String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " out of bounds " + size);
        }

        array[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.

    @Override
    public String remove(String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        int index = indexOf(item);
        if(index == -1)
            throw new RuntimeException("item " + item + "is not found");
        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.

    @Override
    public String remove(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " out of bounds " + size);
        }

        String obj = array[index];
        System.arraycopy(array, index + 1, array, index, size);
        size--;

        return obj;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.

    @Override
    public int indexOf(String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        for(int i = 0; i < size; i++) {
            if(array[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.

    @Override
    public int lastIndexOf(String item) {
        if(item == null)
            throw new NullPointerException("Item shouldn't be NULL");

        for(int i = size - 1; i >= 0; i--) {
            if(array[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.

    @Override
    public String get(int index) {
        if(index < 0 || index >= this.size) {
            throw new RuntimeException();
        }

        return array[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null)
            throw new NullPointerException("List shouldn't be NULL");

        if(this == otherList)
            return true;

        if(size != otherList.size())
            return false;

        for(int i = 0; i < size; i++) {
            if(!array[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    // Вернуть фактическое количество элементов.

    @Override
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Удалить все элементы из списка.

    @Override
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
