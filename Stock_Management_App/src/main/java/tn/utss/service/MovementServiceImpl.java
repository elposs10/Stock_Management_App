package tn.utss.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.utss.model.Movement;
import tn.utss.repository.MovementRepository;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	MovementRepository movementRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	private static final Logger L = LogManager.getLogger(MovementServiceImpl.class);

	@Override
	public List<Movement> retrieveAllMovements() {
		return movementRepository.findAll();
	}

	@Override
	public Movement retrieveMovement(long idMovement) {
		Movement Movement = movementRepository.findById(idMovement).get();
		L.info("Movement returned +++ :" + Movement);
		return Movement;
	}

	@Override
	public Movement addMovement(Movement m) {
		m.setIdMovement(sequenceGeneratorService.generateSequence(Movement.SEQUENCE_NAME));
		return movementRepository.save(m);
	}

	@Override
	public Movement updateMovement(Movement c) {
		return movementRepository.save(c);
	}

	@Override
	public void deleteMovement(long idMovement) {
		movementRepository.deleteById(idMovement);

	}

}
