package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{
        int i, j; String name;
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C c = new C(i,j,name);
            c.i = i; c.j = j; c.name = name;
            return c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof C)) return false;

            C c = (C) o;

            if (i != c.i) return false;
            if (j != c.j) return false;
            return name != null ? name.equals(c.name) : c.name == null;

        }

        @Override
        public int hashCode() {
            int result = i*j;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
