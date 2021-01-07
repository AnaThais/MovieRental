package video.store.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import video.store.model.Register;
import video.store.repository.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
	RegisterRepository registerRepository;

	public void addRegister(final Register register) {

		register.setStartDate(new Date());
		registerRepository.save(register);
	}

	public Register findById(final Integer id) {

		return registerRepository.findById(id).get();
	}

	public Iterable<Register> findAll() {

		return registerRepository.findAll();
	}

	public void updateRegister(final Register register) {

		registerRepository.save(register);
	}

	public void deleteRegister(final Integer id) {

		registerRepository.deleteById(id);
	}
}
