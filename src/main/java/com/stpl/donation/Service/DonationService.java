package com.stpl.donation.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.stpl.donation.model.Donation;
import com.stpl.donation.repository.DonationRepository;

@Service
@Transactional
public class DonationService {


  @Autowired
  private DonationRepository donationRepository;

  public List<Donation> getAllActiveList() {
    return donationRepository.findByStatus(0);
  }

  public void save(Donation donation) {
    donationRepository.save(donation);
  }

  public Donation findById(Long id) {
    Optional<Donation> byId = donationRepository.findById(id);
    return byId.orElseThrow(() -> {
      return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "donation.not-found");
    });
  }

}
