package com.stpl.volunteer.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stpl.volunteer.model.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{

}
