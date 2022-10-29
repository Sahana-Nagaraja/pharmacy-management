package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.dto.BillingRequestDTO;
import com.bits.dbms.assignment.pharmacy.entity.Billing;
import com.bits.dbms.assignment.pharmacy.entity.BillingDetails;
import com.bits.dbms.assignment.pharmacy.repository.BillingDetailsRepository;
import com.bits.dbms.assignment.pharmacy.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillingServiceImpl implements BillingService {

    private final InventoryService inventoryService;
    private final BillingRepository billingRepository;
    private final BillingDetailsRepository billingDetailsRepository;

    public BillingServiceImpl(InventoryService inventoryService, BillingRepository billingRepository, BillingDetailsRepository billingDetailsRepository) {
        this.inventoryService = inventoryService;
        this.billingRepository = billingRepository;
        this.billingDetailsRepository = billingDetailsRepository;
    }


    @Override
    public Billing findById(Integer billingId) {
        Optional<Billing> optionalBilling = billingRepository.findById(billingId);
        return optionalBilling.orElse(null);
    }

    @Override
    public Billing saveBill(BillingRequestDTO billingRequestDTO) {
        Billing billing = Billing.builder()
                .customer_id(billingRequestDTO.getCustomerId())
                .discount_amount(billingRequestDTO.getDiscountAmount())
                .payment_mode(billingRequestDTO.getPaymentMode())
                .offer_id(billingRequestDTO.getOfferId())
                .store_id(billingRequestDTO.getStoreId())
                .modified_by(billingRequestDTO.getStoreId())
                .created_by(billingRequestDTO.getStoreId())
                .net_amount(calculateNetAmount(billingRequestDTO.getInventoryQtyMap()))
                .build();
        Billing savedBilling = billingRepository.save(billing);
        List<BillingDetails> billingDetailsList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : billingRequestDTO.getInventoryQtyMap().entrySet()) {
            billingDetailsList.add(
                    BillingDetails.builder()
                            .billing_id(savedBilling.getBilling_id())
                            .inventory_id(entry.getKey())
                            .quantity(entry.getValue())
                            .build());
        }
        billingDetailsRepository.saveAll(billingDetailsList);
        return savedBilling;
    }

    private Integer calculateNetAmount(HashMap<Integer, Integer> inventoryQtyMap) {
        Integer totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : inventoryQtyMap.entrySet()) {
            totalAmount += inventoryService.findInventoryById(entry.getKey()).getUnit_selling_price()*entry.getValue();
        }
        return totalAmount;
    }

}
