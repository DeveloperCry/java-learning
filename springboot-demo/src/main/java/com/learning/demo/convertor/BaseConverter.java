package com.learning.demo.convertor;

import java.util.List;

/**
 * 这个借口的存在是为了领域模型与其他模型之间的相互转换
 * @param <O> Object
 * @param <E> Entity
 */
public interface BaseConverter<O, E> {

    /**
     * Object转Entity
     */
    E toEntity(O obj);

    /**
     * Entity转Object
     */
    O toObj(E entity);

    /**
     * Object集合转Entity集合
     */
    List<E> toEntity(List<O> objList);

    /**
     * Entity集合转Object集合
     */
    List<O> toObj(List<E> entityList);
}
