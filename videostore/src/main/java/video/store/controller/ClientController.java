package video.store.controller;

import java.util.List;

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

import video.store.model.Client;
import video.store.service.ClientService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping(path = "/addClient")
	public @ResponseBody void addClient(@RequestBody final Client client) {

		clientService.addClient(client);
	}

	@GetMapping(path = "/findById/{id}")
	public @ResponseBody Client findById(@PathVariable final Integer id) {

		return clientService.findById(id);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody List<Client> findAll() {

		return clientService.findAll();
	}

	@PutMapping(path = "/updateClient")
	public @ResponseBody void updateClient(@RequestBody final Client client) {

		clientService.updateClient(client);
	}

	@DeleteMapping(path = "/deleteClient/{id}")
	public @ResponseBody void deleteClient(@PathVariable final Integer id) {

		clientService.deleteClient(id);
	}
}
