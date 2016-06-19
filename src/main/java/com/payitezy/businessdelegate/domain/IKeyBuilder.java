package com.payitezy.businessdelegate.domain;

import java.io.Serializable;

/**
 * @author varma
 *
 */
public interface IKeyBuilder<V extends Serializable> {
    /**
     * Build an of the specified type
     *
     * @return V
     */
    V build();
}
