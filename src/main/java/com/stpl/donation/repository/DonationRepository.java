package com.stpl.donation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.stpl.donation.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{

  List<Donation> findByStatus(int i);


}
