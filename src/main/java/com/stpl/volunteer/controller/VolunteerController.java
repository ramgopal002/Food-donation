package com.stpl.volunteer.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stpl.volunteer.entities.request.VolunteerEntityRequest;
import com.stpl.volunteer.model.Volunteer;
import com.stpl.volunteer.service.VolunteerService;


@RestController()
@RequestMapping("/food")
public class VolunteerController {

  @Autowired
  private VolunteerService volunteerService;

  @PostMapping("/volunteer")
  public void add(@RequestBody VolunteerEntityRequest request) throws UnsupportedEncodingException {

    Volunteer volunteer = new Volunteer();
    volunteer.setAddress(request.getAddress());
    volunteer.setName(request.getName());
    volunteer.setPhone(request.getPhone());
    String password = request.getPassword();
    password = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
    volunteer.setPassword(password);
    volunteerService.create(volunteer);

  }
  
  @PostMapping("/volunteer/login")
  public void login() {
    
  }

  @GetMapping("/volunteer")
  public List<Volunteer> get() {
    return volunteerService.findAll();
  }

}
