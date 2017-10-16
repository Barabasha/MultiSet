package MultiSet;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
Для себя:
Создать класс MultiSet с методами:
1. add - добавление нового элемента в multiSet
2. frequencyElem - частота вхождений объекта в multiSet
3. union - объединение двух multiSet
4. intersect - пересечение двух multiSet
5. isSubSet - является ли текущий multiSet подмножеством другого multiSet
6. size - количество объектов multiSet
7. создание коллекции с уникальными объектами, на основе текущего multiSet
 */

class MultiSet<E> {
    private List<E> list = new ArrayList<E>();

    MultiSet(List<E> list) {
        this.list = list;
    }

    private void add(E elem) {
        list.add(elem);
    }

    int frequencyElem(E elem) {
        int count = 0;
        for (E obj : list) {
            if (elem == obj) {
                count++;
            }
        }
        return count;
    }

    void union(MultiSet<E> other) {
        list.addAll(other.list);
    }

    MultiSet<E> intersect(MultiSet<E> other) {
        MultiSet<E> result = new MultiSet<E>(new ArrayList<E>());
        for (E obj : list) {
            if (other.frequencyElem(obj) != 0) {
                result.add(obj);
            }
        }
        return result;
    }

    boolean isSubSet(MultiSet<E> other) {
        for (E obj : list) {
            if ((other.frequencyElem(obj) == 0) || (other.frequencyElem(obj) < this.frequencyElem(obj))) {
                return false;
            }
        }
        return true;
    }

    int size() {
        return list.size();
    }

    TreeSet<E> toSet() {
        TreeSet<E> set = new TreeSet<E>();
        set.addAll(list);
        return set;
    }
}

