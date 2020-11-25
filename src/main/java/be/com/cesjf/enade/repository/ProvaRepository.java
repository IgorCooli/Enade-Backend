package be.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.dto.ProvaBasicaDTO;
import be.com.cesjf.enade.dto.QuestaoDTO;
import be.com.cesjf.enade.model.Prova;

@Repository
@Transactional
public interface ProvaRepository extends JpaRepository<Prova, Long>{

	@Query("select new be.com.cesjf.enade.dto.ProvaBasicaDTO"
			+ "(p.id, p.dataProva) "
			+ "from Prova p "
		)
    public List<ProvaBasicaDTO> findAllProva();
	
}
