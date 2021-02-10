package net.wenthura.wenthura.repository;

import net.wenthura.wenthura.model.employeeEvents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEventRepository extends JpaRepository<employeeEvents, Long> {
}
