package org.sid.mapper;

import org.sid.dto.VoyageDTO;
import org.sid.entities.Voyage;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = JourMapper.class)
public interface VoyageMapper {
    VoyageDTO toDto(Voyage voyage);
    Voyage toEntity(VoyageDTO voyageDTO);
    List<VoyageDTO> toDtoList(List<Voyage> voyages);
    List<Voyage> toEntityList(List<VoyageDTO> voyageDTOs);
}
