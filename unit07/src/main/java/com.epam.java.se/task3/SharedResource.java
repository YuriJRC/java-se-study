package com.epam.java.se.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мария on 15.03.2017.
 */
    public class SharedResource {
        private List<Integer> list;

        public SharedResource() {
            list = new ArrayList<>();
        }

        public void setElement(Integer element) {
            list.add(element);
        }

    public List<Integer> getList() {
        return list;
    }

    public Integer getElement() {
            if (list.size() > 0) {
                return list.remove(0);
            }
            return null;
        }
    }
