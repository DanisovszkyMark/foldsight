package hu.evocelot.foldsight.converter;

import org.springframework.stereotype.Component;

/**
 * Converter interface for converting entities into dto.
 *
 * @param <ENTITY> - the entity to convert.
 * @param <DTO>    - the destination dto.
 */
@Component
public interface EntityConverter<ENTITY, DTO> {

    /**
     * For converting entity to dto.
     *
     * @param entity - the entity to convert.
     * @return - with the created dto.
     */
    public DTO convert(ENTITY entity);
}
