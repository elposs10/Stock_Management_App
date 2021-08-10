package tn.utss.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.utss.model.Store;
import tn.utss.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	private static final Logger L = LogManager.getLogger(StoreServiceImpl.class);

	@Override
	public List<Store> retrieveAllStores() {
		return storeRepository.findAll();
	}

	@Override
	public Store retrieveStore(long idStore) {
		Store Store = storeRepository.findById(idStore).get();
		L.info("Store returned +++ :" + Store);
		return Store;
	}

	@Override
	public Store addStore(Store s) {
		s.setIdStore(sequenceGeneratorService.generateSequence(Store.SEQUENCE_NAME));
		return storeRepository.save(s);
	}

	@Override
	public Store updateStore(Store c) {
		return storeRepository.save(c);
	}

	@Override
	public void deleteStore(long idStore) {
		storeRepository.deleteById(idStore);

	}
}
