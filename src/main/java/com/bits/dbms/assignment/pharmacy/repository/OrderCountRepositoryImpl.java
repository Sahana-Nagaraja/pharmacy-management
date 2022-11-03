package com.bits.dbms.assignment.pharmacy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class OrderCountRepositoryImpl implements OrderCountRepositoryWithProcedure {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long getOrderCount(Long storeId) {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("get_total_orders");
        query.setParameter("store_id_in", storeId);
        query.execute();
        return (Long) query.getOutputParameterValue("order_count");
    }
}
