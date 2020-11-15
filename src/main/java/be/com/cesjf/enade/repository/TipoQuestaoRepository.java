package be.com.cesjf.enade.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.model.TipoQuestao;

@Repository
@Transactional
public interface TipoQuestaoRepository extends JpaRepository<TipoQuestao, Long>{
	
	TipoQuestao findByNome(String tipo);
}
