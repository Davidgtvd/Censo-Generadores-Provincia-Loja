package com.tercerotest.controller.tda.queque;

import com.tercerotest.controller.excepcion.ListEmptyException;
import com.tercerotest.controller.excepcion.OverFlowException;
import com.tercerotest.controller.tda.list.LinkedList;

public class QuequeOperation <E> extends LinkedList<E>{
    private Integer top;

    public QuequeOperation(Integer top) {
        this.top = top;
    }
    
    public Boolean verify() {
        return getSize().intValue() <= top.intValue();
    }
    
    public void queque(E dato) throws Exception {
        if(verify()) {
            add(dato, getSize());
        } else {
            throw new OverFlowException("Cola llena");
        }
    }
    
    public E dequeque() throws Exception {
        if(isEmpty()) {
            throw new ListEmptyException("Cola vacia");
        } else {
            return deleteFirst();
        }
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
    
    
    
}
