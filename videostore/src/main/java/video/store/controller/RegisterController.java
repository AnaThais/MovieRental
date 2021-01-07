package video.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import video.store.model.Register;
import video.store.service.RegisterService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/register")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@PostMapping(path = "/addRegister")
	public @ResponseBody void addRegister(@RequestBody final Register register) {

		registerService.addRegister(register);
	}

	@GetMapping(path = "/findById/{id}")
	public @ResponseBody Register findbyId(@PathVariable final Integer id) {

		return registerService.findById(id);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Register> findAll() {

		return registerService.findAll();
	}

	@PutMapping(path = "/updateRegister")
	public @ResponseBody void updateRegister(@RequestBody final Register register) {

		registerService.updateRegister(register);
	}

	@DeleteMapping(path = "/deleteRegister/{id}")
	public @ResponseBody void deleteRegister(@PathVariable final Integer id) {

		registerService.deleteRegister(id);
	}
}
