package org.sid.services;

import jakarta.transaction.Transactional;
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
    @Transactional
    public List<VoyageDTO> getAllVoyages() {
        voyageMapper.toDtoList(voyageRepository.findAll()).stream()
                .forEach(e-> System.out.println(e.getName()));
        return voyageMapper.toDtoList(voyageRepository.findAll());
    }



    @Override
    public VoyageDTO saveVoyage(VoyageDTO voyageDTO) {
        Voyage voyage = voyageMapper.toEntity(voyageDTO);
        return voyageMapper.toDto(voyageRepository.save(voyage));
    }

}
