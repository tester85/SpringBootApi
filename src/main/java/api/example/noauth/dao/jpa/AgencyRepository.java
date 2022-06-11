package api.example.noauth.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api.example.noauth.domain.Agency;
/*
 * // extends PagingAndSortingRepository<Agencia, Long> {
 *  paging results
 * */
public interface AgencyRepository extends JpaRepository<Agency, Long> {

	Agency findAgenciaByCity(String city);
	Agency getAgenciaById(long id);
	// Page findAll(Pageable pageable);
}
