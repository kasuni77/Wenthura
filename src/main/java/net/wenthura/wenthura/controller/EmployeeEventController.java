package net.wenthura.wenthura.controller;

import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.employeeEvents;
import net.wenthura.wenthura.repository.EmployeeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "emp")
public class EmployeeEventController {
	
	private byte[] bytes;

	@Autowired
	private EmployeeEventRepository employeeEventRepository;
	
	@GetMapping("/get")
	public List<employeeEvents> getEmpEvent() {
		return employeeEventRepository.findAll();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/add")
	public void createEmpEvent(@RequestBody employeeEvents employeeEvents) throws IOException {
		employeeEvents.setPicByte(this.bytes);
		employeeEventRepository.save(employeeEvents);
		this.bytes = null;
	}


	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmpEvent(@PathVariable(value = "id") Long vendorId)
			throws ResourceNotFoundException {
		employeeEvents employeeEvents = employeeEventRepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vendorId));
		employeeEventRepository.delete(employeeEvents);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@PutMapping("/update")
	public void updateEmpEvent(@RequestBody employeeEvents employeeEvents) {
		employeeEventRepository.save(employeeEvents);
	}
//
//	@PutMapping("/update")
//	public ResponseEntity<Vendor> updateBook(@PathVariable(value = "id") Long vendorId,
//												@Valid @RequestBody Vendor vendorDetails) throws ResourceNotFoundException {
//		Vendor vendor = vendorRepository.findById(vendorId)
//				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vendorId));
//
//
//		vendor.setAuthor(vendorDetails.getAuthor());
//		vendor.setName(vendorDetails.getName());
//		vendor.setPrice(vendorDetails.getPrice());
//
//		final Vendor updatedVendor = vendorRepository.save(vendor);
//		return ResponseEntity.ok(updatedVendor);
//	}
}
