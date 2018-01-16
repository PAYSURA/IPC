/**
 * 
 */
package com.paysura.controller.secure;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.domain.secure.Credential;
import com.paysura.domain.user.User;

import lombok.Data;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/secure")
public class SecureController {

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from Secure Controller", HttpStatus.OK);
	}

	/**
	 * Checks the {@link Credential} inside the body HTTP POST request and perform
	 * an login action.
	 * 
	 * @param credential
	 *            The credentials.
	 * @return {@link User} if successfull, null else.
	 */
	@PostMapping
	public ResponseEntity<User> login(@Validated(Credential.New.class) @RequestBody final Credential credential) {
		ResponseEntity<User> response;
		
		return response;
	}

}
