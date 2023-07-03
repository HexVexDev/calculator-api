package com.company.project.services;

import java.util.List;

public interface ServiceInterface<T>{
    public void add(T newOne);
    public void remove(T toDelete);
    public List<T> getAll();
    public void saveOrUpdate(T toUpdate);

}
