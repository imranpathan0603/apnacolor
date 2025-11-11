package com.apnacolor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnacolor.entity.BillDetails;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {
	List<BillDetails> findByBillId(Long billId);

}
