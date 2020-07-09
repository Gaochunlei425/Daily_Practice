package com.gcl.module.service.impl;

import com.gcl.module.dao.IProductDao;
import com.gcl.module.domain.Product;
import com.gcl.module.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() throws Exception {
        for (Product pr: productDao.findAll()
        ) {
            System.out.println("ser" + pr);
        }

        return productDao.findAll();
    }

    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
