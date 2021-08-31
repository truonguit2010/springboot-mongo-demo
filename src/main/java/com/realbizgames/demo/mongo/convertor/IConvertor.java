package com.realbizgames.demo.mongo.convertor;

import java.util.List;

public interface IConvertor<F, T> {
    T convert(F f);

    List<T> convert(Iterable<F> f);
}
