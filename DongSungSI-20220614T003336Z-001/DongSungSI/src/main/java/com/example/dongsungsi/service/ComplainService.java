package com.example.dongsungsi.service;

import com.example.dongsungsi.model.Complain;
import java.util.List;

public interface ComplainService {
    public List<Complain> findAll();
    public boolean save(Complain complain);
    public boolean deleteAll();
}
