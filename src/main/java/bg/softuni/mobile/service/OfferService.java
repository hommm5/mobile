package bg.softuni.mobile.service;

import bg.softuni.mobile.model.dto.AddOfferDTO;
import bg.softuni.mobile.model.entity.ModelEntity;
import bg.softuni.mobile.model.entity.OfferEntity;
import bg.softuni.mobile.model.entity.UserEntity;
import bg.softuni.mobile.model.mapper.OfferMapper;
import bg.softuni.mobile.repository.ModelRepository;
import bg.softuni.mobile.repository.OfferRepository;
import bg.softuni.mobile.repository.UserRepository;
import bg.softuni.mobile.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper, UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        OfferEntity newOfferEntity = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);
        //TODO-current user should be logged in
        UserEntity seller = userRepository.
                findByEmail(currentUser.getEmail()).orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOfferEntity.setModel(model);
        newOfferEntity.setSeller(seller);

        offerRepository.save(newOfferEntity);
    }


}
