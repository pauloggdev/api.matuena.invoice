package api.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.domain.entity.Serie;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, String> {

    Optional<Serie> findBySeriesCode(String seriesCode);
    boolean existsBySeriesCode(String seriesCode);
}
