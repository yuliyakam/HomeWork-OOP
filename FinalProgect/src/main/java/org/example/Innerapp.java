package org.example;

import java.util.Objects;

public class Innerapp {
    IInterface v;

    /***
     * Можно проверить входной параметр @param v на принадлежность к типу входных данных. При несовпадении запустить
     * создание дефолтного объекта по умолчанию
     */
//            public Innerapp(IInterface v) {
//
//            if (v instanceof IInterface) {
//                this.v = v;
//            }
//            else {
//                this.v = new NullInterface();
//            }
//        }


    /***
     * Совсем обойтись без конструкции if/else
     * @param v
     */
    public Innerapp(IInterface v){
        this.v =  Objects.requireNonNullElseGet(v, NullInterface::new);
    }

    void write() {
        v.print();
    }
}
