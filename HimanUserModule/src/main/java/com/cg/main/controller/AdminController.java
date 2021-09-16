package com.cg.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Admin;
import com.cg.main.exception.AdminNotFoundException;
import com.cg.main.service.IAdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService service;
	
	@GetMapping("/login/{contactNo}/{password}")
	public ResponseEntity<Admin> signIn(@PathVariable String contactNo, @PathVariable String password){
		Admin temp = service.signIn(contactNo,password);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/logout/{contactNo}")
	public ResponseEntity<Admin> signout(@PathVariable String contactNo){
		Admin temp = service.signout(contactNo);
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	

	@PutMapping("/update/{contactNo}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable String contactNo,@RequestBody Admin admin) throws AdminNotFoundException
	{
		Admin updatedAdmin = service.updateAdmin(contactNo,admin);
	    return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);
      }
//	
//	@DeleteMapping("/removeAdmin/{contactNo}")
//	public ResponseEntity<Admin> deleteUser(@PathVariable String contactNo) throws AdminNotFoundException{
//		Admin temp=service.removeAdmin(contactNo);
//		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
//   }
}
