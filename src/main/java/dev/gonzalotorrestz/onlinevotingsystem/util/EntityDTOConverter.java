package dev.gonzalotorrestz.onlinevotingsystem.util;

public interface EntityDTOConverter<Entity, DTO> {
    DTO convertToDTO(Entity entity);

    Entity convertToEntity(DTO dto);
}
