package api.example.noauth.dao.jpa;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import api.example.noauth.domain.Agency;
/*
 * // extends PagingAndSortingRepository<Agencia, Long> {
 *  paging results
 * */
public interface AgencyRepository extends CrudRepository<Agency, Long> {

	Agency findAgenciaByCity(String city);
	Optional<Agency> getAgenciaById(long id);
	// Page findAll(Pageable pageable);
}
