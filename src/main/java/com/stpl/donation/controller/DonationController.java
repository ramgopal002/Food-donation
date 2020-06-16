package com.stpl.donation.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stpl.donation.Service.DonationService;
import com.stpl.donation.entites.request.DonationEntityRequest;
import com.stpl.donation.model.Donation;

@RestController()
@RequestMapping("/food")
public class DonationController {

  @Autowired
  private DonationService donationService;

  @PostMapping("/donation")
  public void add(@RequestBody DonationEntityRequest request) {
    Donation donation = new Donation();
    Date date = new Date();
    donation.setCreateDate(date.getTime());
    donation.setModifyDate(date.getTime());
    donation.setStatus(0);

    donation.setAddress(request.getAddress());
    Date collectiondate = request.getCollectiondtime();
    donation.setCollectiondtime(collectiondate.getTime());
    donation.setEvent(request.getEvent());
    donation.setFoodname(request.getFoodname());
    donation.setFoodqty(request.getFoodqty());
    donation.setName(request.getName());
    donation.setPhone(request.getPhone());
    donationService.save(donation);
  }

  @GetMapping("/donation")
  public List<Donation> get() {
    return donationService.getAllActiveList();
  }

  @PutMapping("/donation/accept/{volunteerId}/{id}")
  public void updateDonation(@PathVariable Long id, @PathVariable Long volunteerId) {
    Donation donation = donationService.findById(id);
    donation.setStatus(1);
    donation.setVolunteerId(volunteerId);
    donationService.save(donation);
  }
}
