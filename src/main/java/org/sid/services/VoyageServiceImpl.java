package org.sid.services;

import org.sid.dto.VoyageDTO;
import org.sid.entities.Voyage;
import org.sid.mapper.VoyageMapper;
import org.sid.repository.VoyageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VoyageServiceImpl  implements VoyageService{
    private final VoyageRepository voyageRepository;
    private final VoyageMapper voyageMapper;

    public VoyageServiceImpl(VoyageRepository voyageRepository, VoyageMapper voyageMapper) {
        this.voyageRepository = voyageRepository;
        this.voyageMapper = voyageMapper;
    }

    @Override
    public List<VoyageDTO> getAllVoyages() {
        return voyageMapper.toDtoList(voyageRepository.findAll());
    }



    @Override
    public VoyageDTO saveVoyage(VoyageDTO voyageDTO) {
        Voyage voyage = voyageMapper.toEntity(voyageDTO);
        return voyageMapper.toDto(voyageRepository.save(voyage));
    }

}
