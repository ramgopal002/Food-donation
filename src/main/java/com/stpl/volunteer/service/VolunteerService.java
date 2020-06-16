package com.stpl.volunteer.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.stpl.volunteer.model.Volunteer;
import com.stpl.volunteer.repositry.VolunteerRepository;

@Service
@Transactional
public class VolunteerService {

  @Autowired
  private VolunteerRepository volunteerRepository;

  public Volunteer findbyId(Long id) {
    Optional<Volunteer> byId = volunteerRepository.findById(id);
    return byId.orElseThrow(() -> {
      return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "volunteer.not-found");
    });
  }

  public void create(Volunteer volunteer) {
    volunteerRepository.save(volunteer);
  }

  public List<Volunteer> findAll() {
    return volunteerRepository.findAll();
  }
}
